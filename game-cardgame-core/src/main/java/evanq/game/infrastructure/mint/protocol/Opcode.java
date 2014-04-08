package evanq.game.infrastructure.mint.protocol;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import evanq.game.cardgame.interfaces.dto.LoginDTO;
import evanq.game.helper.New;
import evanq.game.net.AbstractPacket;
import evanq.game.net.DefaultPacketAllocator;

/**
 * 
 * 从指定的配置文件中读取 协议号与协议类
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public final class Opcode {
	
	private static Logger logger = LoggerFactory.getLogger(Opcode.class);
	
	private static Map<Integer,String> nameMapping = new LinkedHashMap<Integer,String>();
	
	private static Map<Integer,NamingPacketSchema> schemas = New.hashMap();
	
	
	/**
	 * 
	 * 协议号的定义
	 * 
	 * @param type
	 * @param index
	 * @return
	 */
	public static int getCode(int type, int index){
		return (1<<type) * 10000 + index;
	}
	public static void opcode(int code, String name){
		nameMapping.put(code,name);
	}
	
	@SuppressWarnings({ "unchecked"})
	public static void mappingCodeToClass(){
		
		for (Map.Entry<Integer,String> entry: nameMapping.entrySet()) {
			NamingPacketSchema namingPacketSchema = new NamingPacketSchema(entry.getValue());
			if (namingPacketSchema.exists()) {
				Class<?> forName = namingPacketSchema.forName();
				Class<?> superclass = forName;
				boolean isPacket = false;
				//沿着继承树查找
				do{
					if( superclass.isAssignableFrom(AbstractPacket.class)){
						isPacket = true;
						schemas.put(entry.getKey(), namingPacketSchema);
						DefaultPacketAllocator.R(entry.getKey(), (Class<? extends AbstractPacket>)forName);
						break;
					}else{						
						superclass = superclass.getSuperclass();
					}
					
				}while(superclass!=null && superclass!= Object.class);				
				
				if(!isPacket){
					logger.warn("{} 不是 {} 子类",entry.getValue(), AbstractPacket.class);
				}
				
			}else{
				logger.warn("找不到 {}", entry.getValue());
			}
		}
		
	}
	
	
	/**
	 * 
	 * 从配置文件中读取协议号与协议包
	 * @param filename
	 */
	public void opcodeFromINIProtocolFile(String filename){	

		OpcodeSchemaMapper mapper = new INIOpcodeSchemaMapper(filename);

		List<Entry<Integer, String>> listEntry = mapper.listEntry();
		for (Entry<Integer, String> entry : listEntry) {
			opcode(entry.getKey(), entry.getValue());
		}
		
		//analytis();
		
	}
	
	
	public static void main(String[] args) {
		
		//打印opcode 映射
//		System.out.println(getCode(1, 1));
//		System.out.println(getCode(2, 1));
//		System.out.println(getCode(3, 1));
//		System.out.println(getCode(4, 1));
		
		
		Opcode opcode = new Opcode();
		opcode.opcodeFromINIProtocolFile("protocol.ini");
		
		LoginDTO dto = DefaultPacketAllocator.newPacket(LoginDTO.class);
		System.out.println(dto);
//		configWriter();
	}	
	/**
	 * 协议版本
	 * @author Evan cppmain@gmail.com
	 *
	 */
	class OpcodeVersion{
		
	}
	
	/**
	 * 
	 * 概念：暂定用描述和定位 PacketSchema
	 * 
	 * @author Evan cppmain@gmail.com
	 *
	 */
	class PacketId {
		
	}

}
