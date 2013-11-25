package evanq.game.helper;

import java.text.DecimalFormat;
import java.util.concurrent.TimeUnit;

/**
 * 
 * 时间转换器
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class TimeUtil {

	static final long NANOS_IN_ONE_MICROSECOND = 1000;

	static final long NANOS_IN_ONE_MILLISECOND = NANOS_IN_ONE_MICROSECOND * 1000;

	static final long NANOS_IN_ONE_SECOND = NANOS_IN_ONE_MILLISECOND * 1000;

	static final long NANAS_IN_ONE_MINUTES= NANOS_IN_ONE_SECOND * 60;
	
	private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat(
			"0.000");

	static TimeUnit selectDurationUnitForDisplay(long durationInNanos) {
		if (durationInNanos < 10 * NANOS_IN_ONE_MICROSECOND) {
			return TimeUnit.NANOSECONDS;
		} else if (durationInNanos < 10 * NANOS_IN_ONE_MILLISECOND) {
			return TimeUnit.MICROSECONDS;
		} else if (durationInNanos < 10 * NANOS_IN_ONE_SECOND) {
			return TimeUnit.MILLISECONDS;
		} else {
			return TimeUnit.SECONDS;
		}
	}

	static public double convertToMicros(long nanos) {
		return (double) nanos / NANOS_IN_ONE_MICROSECOND;
	}

	static public double convertToMillis(long nanos) {
		return (double) nanos / NANOS_IN_ONE_MILLISECOND;
	}

	static public double convertToSeconds(long nanos) {
		return ((double) nanos / NANOS_IN_ONE_SECOND);
	}
	
	static public double convertToMinuts(long nanos){
		return ((double) nanos / NANAS_IN_ONE_MINUTES);
	}

	/**
	 * 将nano格式的时间转换成制定的时间格式
	 * @param nanos
	 * @param timeUnit
	 * @return
	 */
	public static String time(long nanos, TimeUnit timeUnit) {
		
		StringBuffer buf = new StringBuffer();
		
		switch (timeUnit) {
		case NANOSECONDS:
			buf.append(nanos);
			break;
		case MICROSECONDS:
			
			double micros = convertToMicros(nanos);
			buf.append(DECIMAL_FORMAT.format(micros));
			break;
		case MILLISECONDS:
			double millis = convertToMillis(nanos);
			buf.append(DECIMAL_FORMAT.format(millis));
			break;
		case SECONDS:
			double seconds = convertToSeconds(nanos);
			buf.append(DECIMAL_FORMAT.format(seconds));
			break;
		case MINUTES:
			double minutes= convertToMinuts(nanos);
			buf.append(DECIMAL_FORMAT.format(minutes));
			break;
		case HOURS:
			throw new UnsupportedOperationException("不支持将nanos 转换成小时格式");
		case DAYS:
			throw new UnsupportedOperationException("不支持将nanos 转换成天数格式");
			
		}
		return buf.toString();
	}

}
