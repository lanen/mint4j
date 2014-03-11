package evanq.game.cardgame.infrastructure.es.components;

import com.artemis.Component;

/**
 * 
 * ��ɫ����ң�
 * @author Evan cppmain@gmail.com
 *
 */
public class Player extends Component {

	/**
	 * ��ɫID
	 */
	private int roleId;
	
	/**
	 * ��ɫ����
	 */
	private String name;

	/**
	 * ��ɫְҵ
	 */
	private int profession;
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getProfession() {
		return profession;
	}

	public void setProfession(int profession) {
		this.profession = profession;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

}
