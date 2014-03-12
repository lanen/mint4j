package evanq.game.cardgame.interfaces.role;

public interface IAccountFacade {
	
	public void login(String account,String password);
	
	
	public void logout(String account);
	
	
	public void createRole();
	
	
	public void deleteRole();
	
}
