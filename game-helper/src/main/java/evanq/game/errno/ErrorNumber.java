package evanq.game.errno;

/**
 * 错误有级别之分，实现会根据级别将错误分发到具体的处理器
 * 
 * 定义错误代号，和错误描述
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class ErrorNumber {
	
	/** 错误级别 */
	private int level;
	
	/** 代号 */
	private int errno;
	
	/** 错误描述 */
	private String error;

	public int getErrno() {
		return errno;
	}

	public void setErrno(int errno) {
		this.errno = errno;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
}
