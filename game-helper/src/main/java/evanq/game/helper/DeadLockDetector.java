package evanq.game.helper;

import java.lang.management.LockInfo;
import java.lang.management.ManagementFactory;
import java.lang.management.MonitorInfo;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

import evanq.game.errno.ExitCode;
import evanq.game.utils.ExceptionUtils;


/**
 * 
 * 死锁监听器
 * 
 * @author Evan
 * 
 */
public class DeadLockDetector extends Thread {

	
	/** 出现死锁，什么都不做 */
	public static final byte NOTHING = 0;

	/** 出现死锁，重新启动 */
	public static final byte RESTART = 1;

	/** 检测死锁的时间间隔 */
	private final int sleepTime;
	/**
	 * ThreadMXBean
	 */
	private final ThreadMXBean tmx;

	private final byte doWhenDL;

	public DeadLockDetector(int sleepTime, byte doWhenDL) {
		super("DeadLockDetector");
		this.sleepTime = sleepTime * 1000;
		this.tmx = ManagementFactory.getThreadMXBean();
		this.doWhenDL = doWhenDL;
	}

	@Override
	public synchronized void run() {

		boolean deadlock = false;
		while (!deadlock) {

			try {
				long[] ids = tmx.findDeadlockedThreads();

				if (ids != null) {
					/** deadlock found :/ */
					deadlock = true;
					ThreadInfo[] tis = tmx.getThreadInfo(ids, true, true);
					String info = "DeadLock Found!\n";
					for (ThreadInfo ti : tis) {
						info += ti.toString();
					}

					for (ThreadInfo ti : tis) {
						LockInfo[] locks = ti.getLockedSynchronizers();
						MonitorInfo[] monitors = ti.getLockedMonitors();
						if (locks.length == 0 && monitors.length == 0) {
							/** this thread is deadlocked but its not guilty */
							continue;
						}

						ThreadInfo dl = ti;
						info += "Java-level deadlock:\n";
						info += "\t" + dl.getThreadName()
								+ " is waiting to lock "
								+ dl.getLockInfo().toString()
								+ " which is held by " + dl.getLockOwnerName()
								+ "\n";
						while ((dl = tmx.getThreadInfo(
								new long[] { dl.getLockOwnerId() }, true, true)[0])
								.getThreadId() != ti.getThreadId()) {
							info += "\t" + dl.getThreadName()
									+ " is waiting to lock "
									+ dl.getLockInfo().toString()
									+ " which is held by "
									+ dl.getLockOwnerName() + "\n";
						}
					}
					ExceptionUtils.getTrace().error(info);

					if (doWhenDL == RESTART) {
						System.exit(ExitCode.CODE_RESTART);
					}
				}
				Thread.sleep(sleepTime);
			} catch (Exception e) {
				ExceptionUtils.getTrace().error("{}",e);
			}
		}

	}

}
