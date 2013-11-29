package evanq.game.tag;

/**
 * 
 * 版本标签
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class Tag {

	/** 主版本 */
	private int master;
	
	/** 子版本 */
	private int minor;
	
	/** 修正版本 */
	private int revision;
	
	/** 编译版本 */
	private int build;
	
	public int getMaster() {
		return master;
	}
	public void setMaster(int master) {
		this.master = master;
	}
	public int getMinor() {
		return minor;
	}
	public void setMinor(int minor) {
		this.minor = minor;
	}
	public int getRevision() {
		return revision;
	}
	public void setRevision(int revision) {
		this.revision = revision;
	}
	public int getBuild() {
		return build;
	}
	public void setBuild(int build) {
		this.build = build;
	} 
	
	public String toString(){
		StringBuffer buf = new StringBuffer();
		buf.append(master).append('.').
		append(minor).append('.').
		append(revision).
		append('(').append(build).append(')');
		
		return buf.toString();
	}
}
