package evanq.game.utils;

public class ExceptionUtils {

	public static void throwException(Throwable t) {
//		if (hasUnsafe()) {
//			PlatformDependent0.throwException(t);
//		} else {
//		}
		ExceptionUtils.<RuntimeException> throwException0(t);
	}

	@SuppressWarnings("unchecked")
	private static <E extends Throwable> void throwException0(Throwable t)
			throws E {
		throw (E) t;
	}

}
