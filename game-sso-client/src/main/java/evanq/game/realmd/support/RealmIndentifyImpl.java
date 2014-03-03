package evanq.game.realmd.support;

import evanq.game.realmd.RealmIndentify;

/**
 * 
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class RealmIndentifyImpl implements RealmIndentify {

	private int rawId;
	
	public RealmIndentifyImpl(int rawId) {
		this.rawId = rawId;
	}
	
	public String toString(){
		return ""+rawId;
	}
	
}
