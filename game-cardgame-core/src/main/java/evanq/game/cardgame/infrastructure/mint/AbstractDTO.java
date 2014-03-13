package evanq.game.cardgame.infrastructure.mint;

import evanq.game.net.AbstractPacket;
import evanq.game.net.NetPacketType;

/**
 * 
 * 子类无需实现 <b>execute()</b>
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public abstract class AbstractDTO extends AbstractPacket {

	protected AbstractDTO(NetPacketType packetType) {
		super(packetType);
	}

	@Override
	public void execute() {
		CommandExecutorRegistry.getInstance().action(this);
	}

}
