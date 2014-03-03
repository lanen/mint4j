package evanq.game.realmd.support;

import evanq.game.realmd.Realm;
import evanq.game.realmd.RealmIndentify;
import evanq.game.realmd.RealmStatus;
import evanq.game.realmd.RealmStatus;

/**
 * 
 * 会根据分区的类型，选择分区的管理策略。
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public abstract class AbstractRealm implements Realm {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4041083994940619231L;


	/**
	 * The Global Realm Id
	 * 
	 */
	private int id;
	
	private RealmStatus status;
	
	/**
	 * The name Of Realm. Maybe use i18n.
	 */
	private String name;
	
	
	/**
	 * The flag for Reaml 
	 */
	private int flag;
	
	private int port;
	
	private int population;
	
	private String address;
	
	private int icon;
	
	public AbstractRealm(int rawId) {
		
		//Step 1. create RealmIndentify for realm
		this.id = rawId;
		
	}
	
	/**
	 * 
	 * 
	 * @param rawId
	 * @return
	 */
	private RealmIndentify realmIndentifyWrap(int rawId){
		return new RealmIndentifyImpl(rawId);
	}
	
	@Override
	public int getId() {
		return id;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public boolean isEnable() {
		return flag>0;
	}
	
	public void setName(String n){
		this.name = n;
	}
	
	public void setFlag(int flag){
		this.flag = flag;
	}

	public int getFlag() {
		return flag;
	}

	public void setStatus(RealmStatus status) {
		this.status = status;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setIcon(int icon) {
		this.icon = icon;
	}

	@Override
	public int getPort() {
		return port;
	}

	@Override
	public String getAddress() {
		return address;
	}

	@Override
	public int getIcon() {
		return icon;
	}

	@Override
	public int getPopulation() {
		return population;
	}

	@Override
	public RealmStatus getStatus() {
		return status;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
}
