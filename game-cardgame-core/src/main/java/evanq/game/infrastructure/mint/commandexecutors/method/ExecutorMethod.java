package evanq.game.infrastructure.mint.commandexecutors.method;

import java.lang.reflect.Method;

import org.apache.commons.lang3.Validate;

/**
 * 方法级别的命令处理器
 * @author Evan cppmain@gmail.com
 *
 */
public class ExecutorMethod {

	private final Object executor;

	private final Method method;
	
	private ExecutorMethodParameter[] parameters;
	
	public ExecutorMethod(Object executor,Method method) {
		
		Validate.notNull(method);
		
		this.executor = executor;
		
		this.method = method;
		
		this.parameters = initParameters(this.method);
	}
	
	private ExecutorMethodParameter[] initParameters(Method method) {
		
		int len = method.getParameterTypes().length;
		ExecutorMethodParameter[] result = new ExecutorMethodParameter[len];
		for (int i = 0; i < len; i++) {
			result[i] = ExecutorMethodParameter.create(method, i);
		}
		return result;
	}
	
	/**
	 * 
	 * 获取方法的所属实例
	 * 
	 */
	public Object getExecutor() {
		return this.executor;
	}

	/**
	 * Returns the method for this handler method.
	 */
	public Method getMethod() {
		return this.method;
	}

	/**
	 * 
	 */
	public Class<?> getExecutorKlass() {
		return executor.getClass();
	}
	
	public ExecutorMethodParameter[] getParameters(){
		return this.parameters;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o != null && o instanceof ExecutorMethod) {
			ExecutorMethod other = (ExecutorMethod) o;
			return this.executor.equals(other.executor) && this.method.equals(other.method);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return 31 * this.executor.hashCode() + this.method.hashCode();
	}

}
