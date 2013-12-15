package evanq.game.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.util.Locale;
import java.util.concurrent.BlockingQueue;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * 检测平台的信息
 * 
 * @author Evan cppmain@gmail.com
 * 
 */
public final class PlatformUtils {

	private static final Logger logger = LoggerFactory
			.getLogger(PlatformUtils.class);

	private static final boolean IS_ANDROID = isAndroid0();
	private static final boolean IS_WINDOWS = isWindows0();
	private static final boolean IS_ROOT = isRoot0();
	private static final int JAVA_VERSION = javaVersion0();

	/**
	 * Returns {@code true} if and only if the current platform is Android
	 */
	public static boolean isAndroid() {
		return IS_ANDROID;
	}

	/**
	 * Return {@code true} if the JVM is running on Windows
	 */
	public static boolean isWindows() {
		return IS_WINDOWS;
	}

	/**
	 * Return {@code true} if the current user is root. Note that this method
	 * returns {@code false} if on Windows.
	 */
	public static boolean isRoot() {
		return IS_ROOT;
	}

	/**
	 * Return the version of Java under which this library is used.
	 */
	public static int javaVersion() {
		return JAVA_VERSION;
	}

	@SuppressWarnings("LoopStatementThatDoesntLoop")
	private static int javaVersion0() {
		int javaVersion;

		// Not really a loop
		for (;;) {
			// Android
			if (isAndroid()) {
				javaVersion = 6;
				break;
			}

			try {
				Class.forName("java.time.Clock", false,
						Object.class.getClassLoader());
				javaVersion = 8;
				break;
			} catch (Exception e) {
				// Ignore
			}

			try {
				Class.forName("java.util.concurrent.LinkedTransferQueue",
						false, BlockingQueue.class.getClassLoader());
				javaVersion = 7;
				break;
			} catch (Exception e) {
				// Ignore
			}

			javaVersion = 6;
			break;
		}

		if (logger.isDebugEnabled()) {
			logger.debug("Java version: {}", javaVersion);
		}
		return javaVersion;
	}


	private static boolean isAndroid0() {
		boolean android;
		try {
			Class.forName("android.app.Application", false,
					ClassLoader.getSystemClassLoader());
			android = true;
		} catch (Exception e) {
			android = false;
		}

		if (android) {
			logger.debug("Platform: Android");
		}
		return android;
	}

	private static boolean isWindows0() {
		boolean windows = SystemPropertyUtil.get("os.name", "")
				.toLowerCase(Locale.US).contains("win");
		if (windows) {
			logger.debug("Platform: Windows");
		}
		return windows;
	}

	private static boolean isRoot0() {
		if (isWindows()) {
			return false;
		}

		String[] ID_COMMANDS = { "/usr/bin/id", "/bin/id", "id" };
		Pattern UID_PATTERN = Pattern.compile("^(?:0|[1-9][0-9]*)$");
		for (String idCmd : ID_COMMANDS) {
			Process p = null;
			BufferedReader in = null;
			String uid = null;
			try {
				p = Runtime.getRuntime().exec(new String[] { idCmd, "-u" });
				in = new BufferedReader(new InputStreamReader(
						p.getInputStream(), CharsetUtil.US_ASCII));
				uid = in.readLine();
				in.close();

				for (;;) {
					try {
						int exitCode = p.waitFor();
						if (exitCode != 0) {
							uid = null;
						}
						break;
					} catch (InterruptedException e) {
						// Ignore
					}
				}
			} catch (Exception e) {
				uid = null;
			} finally {
				if (in != null) {
					try {
						in.close();
					} catch (IOException e) {
						// Ignore
					}
				}
				if (p != null) {
					try {
						p.destroy();
					} catch (Exception e) {
						// Android sometimes triggers an ErrnoException.
					}
				}
			}

			if (uid != null && UID_PATTERN.matcher(uid).matches()) {
				logger.debug("UID: {}", uid);
				return "0".equals(uid);
			}
		}

		logger.debug("Could not determine the current UID using /usr/bin/id; attempting to bind at privileged ports.");

		Pattern PERMISSION_DENIED = Pattern
				.compile(".*(?:denied|not.*permitted).*");
		for (int i = 1023; i > 0; i--) {
			ServerSocket ss = null;
			try {
				ss = new ServerSocket();
				ss.setReuseAddress(true);
				ss.bind(new InetSocketAddress(i));
				if (logger.isDebugEnabled()) {
					logger.debug("UID: 0 (succeded to bind at port {})", i);
				}
				return true;
			} catch (Exception e) {
				// Failed to bind.
				// Check the error message so that we don't always need to bind
				// 1023 times.
				String message = e.getMessage();
				if (message == null) {
					message = "";
				}
				message = message.toLowerCase();
				if (PERMISSION_DENIED.matcher(message).matches()) {
					break;
				}
			} finally {
				if (ss != null) {
					try {
						ss.close();
					} catch (Exception e) {
						// Ignore.
					}
				}
			}
		}

		logger.debug("UID: non-root (failed to bind at any privileged ports)");
		return false;
	}
	
}
