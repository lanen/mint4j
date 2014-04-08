package evanq.game.cardgame.interfaces.dto;

import java.io.IOException;

import evanq.game.infrastructure.mint.AbstractDTO;
import evanq.game.net.NetPacketType;
import evanq.game.net.io.DataReader;
import evanq.game.net.io.DataWriter;

/**
 * 
 * @author Evan cppmain@gmail.com
 *
 */
public class LoginDTO extends AbstractDTO {

	private int loginType;
	
	private String account;
	
	private String passwd;

	public LoginDTO() {
		super(NetPacketType.CLIENT);
	}
	
	public int getLoginType() {
		return loginType;
	}

	public void setLoginType(int loginType) {
		this.loginType = loginType;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}


	@Override
	public void writeObject(DataWriter out) throws IOException {
		
		out.write(loginType);
		out.writeUTF(account);
		out.writeUTF(passwd);
		
	}

	@Override
	public void readObject(DataReader reader) throws IOException {
		
		loginType=reader.readInt();
		account = reader.readUTF();
		passwd = reader.readUTF();
		
	}

	@Override
	protected StringBuffer toStringBuffer() {
		return null;
	}

}
