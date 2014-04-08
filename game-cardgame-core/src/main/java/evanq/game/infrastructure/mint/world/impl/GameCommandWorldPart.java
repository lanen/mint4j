package evanq.game.infrastructure.mint.world.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import evanq.game.infrastructure.mint.commandexecutors.DispatchCommand;
import evanq.game.infrastructure.mint.protocol.Opcode;
import evanq.game.infrastructure.mint.world.GameWorldPart;

/**
 * 
 * 游戏通讯协议命令部分
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class GameCommandWorldPart implements GameWorldPart {

	
	private Logger logger = LoggerFactory.getLogger(GameCommandWorldPart.class);
	
	private String basePackageToScan;
	
	/**
	 * 
	 * 协议号的配置文件
	 * 
	 */
	private String[] protocolFilenames;
	
	@Override
	public void buildPart() {
		
		readProtocolFromFiles();
		fetchCommandExecutor();
		
	}
	
	public void setScan(String pkgName){
		this.basePackageToScan = pkgName;
	}

	
	/**
	 * 
	 * 从配置文件总读取 协议号与协议内容映射
	 */
	private void readProtocolFromFiles(){
		
		logger.debug("begin to parse protocol");

		protocolFilenames = new String[] {
				"protocol.ini"
		};
		
		Opcode opcode = new Opcode();
		
		for (int i = 0; i < protocolFilenames.length; i++) {
			opcode.opcodeFromINIProtocolFile(protocolFilenames[i]);
		}
		
		//将协议号与class起来。
		Opcode.mappingCodeToClass();
	}
	
	private void fetchCommandExecutor(){
		
		logger.debug("begin to parse protocol/command executors");
		DispatchCommand.getInstance().initDispatchCommand();
	}
}
