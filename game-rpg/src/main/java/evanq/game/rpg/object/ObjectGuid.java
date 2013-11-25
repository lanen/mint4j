package evanq.game.rpg.object;

/**
 * 
 * 对象全局唯一标示
 * 
 * @author Evan
 *
 */
public final class ObjectGuid  {
	
	// 64  	|    32 
	//entry |  counter
	
	//Global Unique ID
	private long guid;
	
	ObjectGuid(long guid){
		this.guid = guid;
	}
	
	public ObjectGuid(int entityType,int counter){
		this.guid = counter | ((long)entityType<<32);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(null == obj)return false;
		if( ! (obj instanceof ObjectGuid))return false;
	
		ObjectGuid g = (ObjectGuid)obj;
		
		return g.guid == guid;
		
	}
	
	public String toString(){
		StringBuilder b = new StringBuilder();
		b.append(guid);
		return b.toString();
	}
	
}
