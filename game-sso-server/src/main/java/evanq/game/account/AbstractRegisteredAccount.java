package evanq.game.account;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * 
 * @author Evan cppmain@gmail.com
 *
 */

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="flag",
	discriminatorType=DiscriminatorType.INTEGER,	
	columnDefinition="TINYINT(1) DEFAULT 1")
@Table(name="accounts")
public abstract class AbstractRegisteredAccount implements RegisteredAccount,Serializable,Comparable<RegisteredAccount> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8092003561540854036L;
	
	@Id
	@Column(name="id")
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@Column
	private int state;
	@Column
	private int flag;
	@Column
	private String email;
	@Column
	private String account;
	@Column
	private String mobile;
	@Column
	private String passwd;
	
	@Override
	public long getId() {
		return id;
	}

	@Override
	public boolean isEnabled() {
		return state>1;
	}

	@Override
	public int getFlag() {
		return flag;
	}

	@Override
	public String getAccount() {
		return account;
	}

	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public String getMobile() {
		return mobile;
	}

	@Override
	public String getPasswd() {
		return passwd;
	}

	@Override
	public int compareTo(RegisteredAccount o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
