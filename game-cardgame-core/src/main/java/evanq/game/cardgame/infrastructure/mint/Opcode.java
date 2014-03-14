package evanq.game.cardgame.infrastructure.mint;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import evanq.game.cardgame.interfaces.dto.LoginDTO;
import evanq.game.helper.New;
import evanq.game.net.AbstractPacket;
import evanq.game.net.DefaultPacketAllocator;

/**
 * 
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public final class Opcode {
	
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
	
	private static Map<Integer,String> nameMapping = new LinkedHashMap<Integer,String>();
	
	private static Map<Integer,NamingPacketSchema> schemas = New.hashMap();
	
	public static void opcode(int code, String name){
		nameMapping.put(code,name);
	}
	
	@SuppressWarnings({ "unchecked"})
	public static void analytis(){
		
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
					System.out.println(entry.getValue()+"不是 "+ AbstractPacket.class +" 子类");
				}
				
			}else{
				System.out.println("找不到"+entry.getValue());
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
		
		analytis();
		
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
}
