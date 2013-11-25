package evanq.game.net;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.LinkedHashSet;
import java.util.Set;

import evanq.game.net.impl.StaticNetInterfaceBinder;

/**
 * 
 * 网络设备工厂，静态绑定网络设备的实现。
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public final class NetInterfaceFactory {


	static final String BIND_UNSUCCESS_MSG = "无法绑定 [evanq.game.net.INetInterface] 的实现";
	
	
	static public INetInterface getNetInterface(String name){
		INetInterfaceFactory iNetInterfaceFactory = getINetInterfaceFactory();
	
		return 	iNetInterfaceFactory.getNetInterface(name);
	}
	
	static public INetInterface getNetInterface(Class<?> clazz){
		return getNetInterface(clazz.getName());
	}
	
	//静态绑定的状态
	
	static final int BIND_STATE_NIL        = 0;
	static final int BIND_STATE_BINDING    = 1;
	static final int BIND_STATE_SUCCESSFUL = 2;
	static final int BIND_STATE_FAILED     = 3;
	  
	
	static int NI_BIND_STATE = BIND_STATE_NIL;

	private NetInterfaceFactory(){
		
	}
	
	
	private final static INetInterfaceFactory getINetInterfaceFactory(){
		
		if (BIND_STATE_NIL == NI_BIND_STATE) {
			bind();
		}
		switch(NI_BIND_STATE){
			
		case BIND_STATE_SUCCESSFUL:
			return StaticNetInterfaceBinder.getInstance().getINetInterfaceFactory();
		}
		
		throw new IllegalStateException("Unreachable code");
		
	}
	

	
	 /**
	 * 
	 * 绑定逻辑的实现
	 * 
	 */
	private final static void bind(){
		
		//step 1. 查找类路径

		try {
			
			Set<URL> staticLoggerBinderPathSet = findPossibleStaticBinderPathSet();
			reportMultipleBindingAmbiguity(staticLoggerBinderPathSet);

			// 实现绑定
			StaticNetInterfaceBinder.getInstance();

			// 设置绑定状态
			NI_BIND_STATE = BIND_STATE_SUCCESSFUL;
			reportActualBinding(staticLoggerBinderPathSet);

		} catch (Exception e) {
			throw new IllegalStateException(
					"Unexpected initialization failure", e);
		}

	}

	//静态绑定查找的实现路径
	private static String STATIC_BINDER_PATH = "evanq/game/net/impl/StaticNetInterfaceBinder.class";

	/**
	 * 获取实现类的路径
	 * @return
	 */
	private static Set<URL> findPossibleStaticBinderPathSet() {
		
		Set<URL> staticLoggerBinderPathSet = new LinkedHashSet<URL>();
		try {
			ClassLoader loggerFactoryClassLoader = NetInterfaceFactory.class.getClassLoader();
			Enumeration<URL> paths;
			if (loggerFactoryClassLoader == null) {
				paths = ClassLoader.getSystemResources(STATIC_BINDER_PATH);
			} else {
				paths = loggerFactoryClassLoader.getResources(STATIC_BINDER_PATH);
			}
			
			while (paths.hasMoreElements()) {
				URL path = (URL) paths.nextElement();
				staticLoggerBinderPathSet.add(path);
			}
		} catch (IOException ioe) {
			System.err.println("Error getting resources from path:" + ioe);
		}
		return staticLoggerBinderPathSet;
	}


	/**
	 * 
	 * 报告可能产生歧义绑定的路径
	 * 
	 * @param staticBinderPathSet
	 */
	private static void reportMultipleBindingAmbiguity(Set<URL> staticBinderPathSet) {
		for (URL url : staticBinderPathSet) {
			System.out.println("Found binding in [" + url + "]");
		}
	}
	
	private static void reportActualBinding(Set<URL> staticBinderPathSet) {
		for (URL url : staticBinderPathSet) {
			System.out.println("Actual binding is of type [" + url + "]");
		}
	}

}
