package evanq.game.cardgame.infrastructure.mint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class NamingPacketSchema extends PacketSchema {
	
	private Logger logger = LoggerFactory.getLogger(NamingPacketSchema.class);
	
	private String nameOfPacket;
	
	public NamingPacketSchema(String name) {
	
		this.nameOfPacket = name;
	}
	
	public Class<?> forName() {
		
		try {
			Class<?> clazz = Class.forName(nameOfPacket);
			return clazz;
		} catch (ClassNotFoundException e) {
			//e.printStackTrace();
			logger.warn("找不到数据包{} \n{}",nameOfPacket,e);
		}
		
		return null;
	}
	
	/**
	 * 
	 * 检查是否存在数据包
	 * 
	 * @return
	 */
	public boolean exists(){
		return null != forName();
	}

}
