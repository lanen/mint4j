package evanq.game.cardgame.infrastructure.mint;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import evanq.game.helper.New;
import evanq.game.helper.Registry;
import evanq.game.net.IPacket;


/**
 * 
 * 将来自Socket的Packet分发到 CommandListener。
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class CommandExecutorRegistry  {
	
	private Logger logger = LoggerFactory.getLogger(CommandExecutorRegistry.class);
	
	private CommandExecutorRegistry(){
		
	}
	
	private static class Singleton{
		private static CommandExecutorRegistry INSTANCE = new CommandExecutorRegistry();
	}
	public static CommandExecutorRegistry getInstance(){
		return Singleton.INSTANCE;
	}
	
	/**
	 * 
	 * 命令与命令控制器注册表
	 * 
	 */
	private Registry<Class<?>,CommandListener<?>> registry = New.registry();
	
	@SuppressWarnings("unchecked")
	public void  action(IPacket dto){
		
		//将命令分发出去
		if(registry.has(dto.getClass())){
			CommandListener<IPacket> commandListener = (CommandListener<IPacket>)registry.get(dto.getClass());
			commandListener.action(dto);
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public void scanAndRegisterCommandExecutor(String[] filenames,CommandListenerResolver resolver){
		
		if(null == resolver){
			throw new NullPointerException("resolver");
		}
		
		for (String string : filenames) {
			logger.info("begin to scan :{}",string);

			AnnotationScanner scanner = new AnnotationScanner(string);
			
			List<Class<?>> clazzList = scanner.findAnnotatedClass(CommandExecutor.class);
			for (Class<?> clazz : clazzList) {
				CommandExecutor annotation = clazz.getAnnotation(CommandExecutor.class);
				Class<?> dtoClazz = annotation.value();
				if(registry.has(dtoClazz)){
					logger.info("Has Dumplate key :{}, replace the preview one",dtoClazz);
				}
				CommandListener<?> cmdListener = resolver.resolver((Class<CommandListener<?>>)clazz);
				if(null != cmdListener){
					logger.debug("resolve {} for {}",clazz,dtoClazz);
					System.out.println(cmdListener);
					registry.put(dtoClazz, cmdListener);
				}else{
					logger.warn("Cannot resolve instance of {}",clazz);
				}
				
			}
		}
	}
	
	/**
	 * 
	 * 实现该接口，将获取CommandListener 的控制
	 * @author Evan cppmain@gmail.com
	 *
	 */
	public static interface CommandListenerResolver {
		
		public CommandListener<?> resolver(Class<CommandListener<?>> clazz);
		public CommandListener<?> resolver(String name,Class<CommandListener<?>> clazz);
		
	}
}
