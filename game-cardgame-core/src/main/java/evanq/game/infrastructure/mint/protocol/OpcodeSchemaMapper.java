package evanq.game.infrastructure.mint.protocol;

import java.util.List;
import java.util.Map;


/**
 * 
 * 
 * 从 protocol.ini 文件中读取协议号与协议映射
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public abstract class OpcodeSchemaMapper {

	/**
	 * 目标文件
	 */
	protected String file ;
	
	public OpcodeSchemaMapper(String file){
		this.file = file;
	}
	
	/**
	 * 从指定的文件中读取映射列表
	 * @return
	 */
	public abstract List<Map.Entry<Integer, String>> listEntry();
	
	/**
	 * 将映射列表存到指定文件中
	 * 
	 * @param entrys
	 * @return
	 */
	public abstract boolean saveEntry(List<Map.Entry<Integer, String>>  entrys);
}
