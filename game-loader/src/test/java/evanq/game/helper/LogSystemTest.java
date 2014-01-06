package evanq.game.helper;

import evanq.game.trace.LogLevel;
import evanq.game.trace.LogSystem;
import evanq.game.trace.Trace;
import evanq.game.trace.TraceConstant;

public class LogSystemTest {

	public static void main(String[] args) {
		
		//参数指定日志输出位置
		LogSystem logSystem = new LogSystem(TraceConstant.GAME_SYSTEM);
		logSystem.setLogLevel(LogLevel.DEBUG);
		
		Trace trace = logSystem.getTrace(LogSystemTest.class);
		trace.info("hello {}","slf4j");
	}

}
