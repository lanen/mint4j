package evanq.game.helper;

import java.util.concurrent.TimeUnit;

/**
 * 
 * 秒表，用于记录运行时间
 * 
 * @author Evan cppmain@gmail.com
 * 
 */
public class StopWatch {

	private String name;

	private long startTime;
	private long stopTime;

	private static final byte INNER_STATE_START = 1;
	private static final byte INNER_STATE_STOP  = 2;

	private byte innerState;

	public StopWatch(String name) {
		start(name);
	}

	public void start(String name) {
		this.name = name;
		this.innerState = INNER_STATE_START;
		startTime = System.nanoTime();
	}

	public StopWatch stop() {

		// 防止多次停止
		if (INNER_STATE_STOP == this.innerState) {
			return this;
		}

		this.innerState = INNER_STATE_STOP;
		this.stopTime = System.nanoTime();
		return this;
	}

	public String getName() {
		return name;
	}

	public final long elapsedTime() {
		if (innerState == INNER_STATE_START) {
			return 0;
		} else {
			return stopTime - startTime;
		}
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("StopWatch [");
		sb.append(name);
		sb.append("] ");
		
		if(INNER_STATE_START == innerState){
			sb.append("STARTED");
		}else if(INNER_STATE_STOP == innerState ){
			sb.append("elapsed time: ");
			sb.append( TimeUtil.time(elapsedTime(), TimeUnit.MILLISECONDS) );
		}

		return sb.toString();
	}

	public void print() {
		System.out.println(toString());
	}
	
	public static void main(String[] args) {
		
		StopWatch watch = new StopWatch("A");
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		watch.stop().print();
	}
}
