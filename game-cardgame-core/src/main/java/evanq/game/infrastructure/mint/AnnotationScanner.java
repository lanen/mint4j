package evanq.game.infrastructure.mint;

import java.io.File;
import java.lang.annotation.Annotation;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 注解扫描器
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class AnnotationScanner {
	
	private Logger logger = LoggerFactory.getLogger(AnnotationScanner.class);

	private String pkgBaseName;

	public AnnotationScanner(String pkgBaseName) {
		if (null == pkgBaseName) {
			throw new NullPointerException("pkgBaseName");
		}

		this.pkgBaseName = pkgBaseName.replace('.', File.separatorChar);
	}

	/**
	 * 获取被注解的类
	 * 
	 * @param annotationClass
	 * @return
	 */
	public List<Class<?>> findAnnotatedClass(Class<? extends Annotation> annotationClass) {
		
		URL resource = annotationClass.getClassLoader()
				.getResource(this.pkgBaseName);
		if(null == resource){
			logger.warn("Cannot find the base package:{}",this.pkgBaseName);
		}
		return findAnnotatedClass(resource,annotationClass);
	}

	/**
	 * 
	 * 查找指定路径下，被注解的类
	 * 
	 * @param url
	 * @param annotationClass
	 * @return
	 */
	protected  List<Class<?>> findAnnotatedClass(URL url,Class<? extends Annotation> annotationClass)  {
		
		ArrayList<Class<?>> clazzList = new ArrayList<Class<?>>();
	
		if(null == url){
			return clazzList;
		}
		
		File dir=null;
		try {
			dir = new File(url.toURI());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		
		if(null == dir){
			return clazzList;
		}
		
		List<Class<?>> classList = findClassInDirectory(dir);
		for (Class<?> clazz : classList) {
			
			if(clazz.isAnnotationPresent(annotationClass)){
				clazzList.add(clazz);
			}
		}
		
		return clazzList;
	}

	/**
	 * 
	 * 递归列出包下面的类
	 * 
	 * @param dir
	 * @return
	 */
	protected List<Class<?>> findClassInDirectory(File dir) {

		LinkedList<Class<?>> list = new LinkedList<Class<?>>();

		if (dir.isDirectory()) {
			File files[] = dir.listFiles();
			for (File file : files) {
				List<Class<?>> findClass = findClassInDirectory(file);
				list.addAll(findClass);
			}
		} else {
			String filePath = dir.getPath();
			
			String classPath = filePath.substring(filePath.lastIndexOf(pkgBaseName),filePath.lastIndexOf('.'));
			String className = classPath.replace(File.separatorChar, '.');

			try {
				Class<?> clazz = Class.forName(className);
				list.add(clazz);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
}
