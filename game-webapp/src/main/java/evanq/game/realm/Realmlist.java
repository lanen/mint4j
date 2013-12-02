package evanq.game.realm;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/realm")
public class Realmlist {

	@GET
	@Path("/realm/list")
	public String list(){
		return "DD";
	}
}
