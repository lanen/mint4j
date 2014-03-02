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
	private RealmIndentify id;
	
	private RealmStatus status;
	
	private String gateUrl;

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
		this.id = realmIndentifyWrap(rawId);
		
		
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
	public RealmIndentify getId() {
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

	public void setGateUrl(String url){
		this.gateUrl = url;
	}

	@Override
	public String getGateUrl() {
		return gateUrl;
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
