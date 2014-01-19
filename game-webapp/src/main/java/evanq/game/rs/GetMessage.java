package evanq.game.rs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("test")
public class GetMessage {

	@GET 
	@Path(value = "/{message}")
	public String echo(@PathParam("message") String message){
		return message +"ddtest";
	}
}
