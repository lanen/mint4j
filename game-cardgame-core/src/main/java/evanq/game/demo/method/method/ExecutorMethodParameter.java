package evanq.game.demo.method.method;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

import org.apache.commons.lang3.Validate;

/**
 * 方法参数
 * 
 * 可以参考 spring在这反面的抽象
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class ExecutorMethodParameter {
	
	
	/**
	 * 拥有改参数的方法反射
	 */
	private final Method method;

	/**
	 * 所属类的构造方法
	 */
	private final Constructor<?> constructor;

	/**
	 * 参数顺序 从1 开始
	 */
	private final int parameterIndex;

	/**
	 * 
	 */
	private Class<?> parameterType;

	/**
	 * 参数的泛型
	 */
	private Type genericParameterType;

	/**
	 * 参数的注解
	 */
	private Annotation[] parameterAnnotations;
	
	private int hash;
	
	
	/**
	 * 参数属于成员方法
	 * @param method
	 * @param parameterIndex
	 */
	public ExecutorMethodParameter(Method method, int parameterIndex) {
		
		Validate.notNull(method);
		
		this.method = method;
		this.parameterIndex = parameterIndex;
		this.constructor = null;
	}
	
	/**
	 * 
	 * 参数数据构造方法 
	 * @param constructor
	 * @param parameterIndex
	 */
	public ExecutorMethodParameter(Constructor<?> constructor, int parameterIndex) {
		
		Validate.notNull(constructor);
		
		this.method = null;
		this.parameterIndex = parameterIndex;
		this.constructor = constructor;
	}
	
	
	/**
	 * 
	 * @return the Method, or {@code null} if none
	 */
	public Method getMethod() {
		return this.method;
	}

	/**
	 * @return the Constructor, or {@code null} if none
	 */
	public Constructor<?> getConstructor() {
		return this.constructor;
	}

	/**
	 * @return the member
	 */
	private Member getMember() {
		return this.method != null ? this.method : this.constructor;
	}

	/**
	 * Returns the wrapped annotated element.
	 * @return the annotated element
	 */
	private AnnotatedElement getAnnotatedElement() {
		return this.method != null ? this.method : this.constructor;
	}

	/**
	 * Return the class that declares the underlying Method or Constructor.
	 */
	public Class<?> getDeclaringClass() {
		return getMember().getDeclaringClass();
	}

	/**
	 * 
	 * 参数在方法的顺序
	 * @return the parameter index (never negative)
	 */
	public int getParameterIndex() {
		return this.parameterIndex;
	}

	/**
	 * 
	 * Set a resolved (generic) parameter type.
	 */
	void setParameterType(Class<?> parameterType) {
		this.parameterType = parameterType;
	}

	/**
	 * Return the type of the method/constructor parameter.
	 * @return the parameter type (never {@code null})
	 */
	public Class<?> getParameterType() {
		if (this.parameterType == null) {
			if (this.parameterIndex < 0) {
				this.parameterType = (this.method != null ? this.method.getReturnType() : null);
			}
			else {
				this.parameterType = (this.method != null ?
					this.method.getParameterTypes()[this.parameterIndex] :
					this.constructor.getParameterTypes()[this.parameterIndex]);
			}
		}
		return this.parameterType;
	}

	/**
	 * 
	 * Return the generic type of the method/constructor parameter.
	 * @return the parameter type (never {@code null})
	 */
	public Type getGenericParameterType() {
		if (this.genericParameterType == null) {
			if (this.parameterIndex < 0) {
				this.genericParameterType = (this.method != null ? this.method.getGenericReturnType() : null);
			}
			else {
				this.genericParameterType = (this.method != null ?
					this.method.getGenericParameterTypes()[this.parameterIndex] :
					this.constructor.getGenericParameterTypes()[this.parameterIndex]);
			}
		}
		return this.genericParameterType;
	}

	/**
	 * Return the annotations associated with the target method/constructor itself.
	 */
	public Annotation[] getMethodAnnotations() {
		return getAnnotatedElement().getAnnotations();
	}

	/**
	 * Return the method/constructor annotation of the given type, if available.
	 * @param annotationType the annotation type to look for
	 * @return the annotation object, or {@code null} if not found
	 */
	public <T extends Annotation> T getMethodAnnotation(Class<T> annotationType) {
		return getAnnotatedElement().getAnnotation(annotationType);
	}

	/**
	 * Return the annotations associated with the specific method/constructor parameter.
	 */
	public Annotation[] getParameterAnnotations() {
		if (this.parameterAnnotations == null) {
			Annotation[][] annotationArray = (this.method != null ?
					this.method.getParameterAnnotations() : this.constructor.getParameterAnnotations());
			if (this.parameterIndex >= 0 && this.parameterIndex < annotationArray.length) {
				this.parameterAnnotations = annotationArray[this.parameterIndex];
			}
			else {
				this.parameterAnnotations = new Annotation[0];
			}
		}
		return this.parameterAnnotations;
	}

	/**
	 * Return the parameter annotation of the given type, if available.
	 * @param annotationType the annotation type to look for
	 * @return the annotation object, or {@code null} if not found
	 */
	@SuppressWarnings("unchecked")
	public <T extends Annotation> T getParameterAnnotation(Class<T> annotationType) {
		Annotation[] anns = getParameterAnnotations();
		for (Annotation ann : anns) {
			if (annotationType.isInstance(ann)) {
				return (T) ann;
			}
		}
		return null;
	}

	/**
	 * Return true if the parameter has at least one annotation, false if it has none.
	 */
	public boolean hasParameterAnnotations() {
		return (getParameterAnnotations().length != 0);
	}

	/**
	 * Return true if the parameter has the given annotation type, and false if it doesn't.
	 */
	public <T extends Annotation> boolean hasParameterAnnotation(Class<T> annotationType) {
		return (getParameterAnnotation(annotationType) != null);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj != null && obj instanceof ExecutorMethodParameter) {
			ExecutorMethodParameter other = (ExecutorMethodParameter) obj;

			if (this.parameterIndex != other.parameterIndex) {
				return false;
			}
			else if (this.getMember().equals(other.getMember())) {
				return true;
			}
			else {
				return false;
			}
		}
		return false;
	}

	@Override
	public int hashCode() {
		int result = this.hash;
		if (result == 0) {
			result = getMember().hashCode();
			result = 31 * result + this.parameterIndex;
			this.hash = result;
		}
		return result;
	}


	/**
	 * 
	 * 快捷方法，用于创建方法参数引用
	 * 
	 * @param methodOrConstructor
	 * @param parameterIndex
	 * @return
	 */
	public static ExecutorMethodParameter create(Object methodOrConstructor, int parameterIndex) {
		if (methodOrConstructor instanceof Method) {
			return new ExecutorMethodParameter((Method) methodOrConstructor, parameterIndex);
		}
		else if (methodOrConstructor instanceof Constructor) {
			return new ExecutorMethodParameter((Constructor<?>) methodOrConstructor, parameterIndex);
		}
		else {
			throw new IllegalArgumentException(
					"Given object [" + methodOrConstructor + "] is neither a Method nor a Constructor");
		}
	}

}
