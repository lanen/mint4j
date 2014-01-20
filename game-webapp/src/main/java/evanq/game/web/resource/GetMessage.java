package evanq.game.web.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;

@Path("test")
public class GetMessage extends Application {

	@GET 
	   @Produces("text/plain")
	   @Consumes("text/plain")
	@Path("{message}")
	public String echo(@PathParam("message") String message){
		return message +"ddtest";
	}
	
}
