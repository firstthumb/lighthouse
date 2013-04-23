package net.javaci.lighthouse.frontend.rest;

import net.javaci.lighthouse.frontend.context.SpringApplicationContext;
import net.javaci.lighthouse.frontend.dao.ServerDao;
import net.javaci.lighthouse.frontend.model.Server;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * User: ekocaman
 * Date: 4/22/13
 */
@Path("/server")
public class ServerService {

    @GET
    @Path("/print")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response printMessage() {
        Server s = new Server();

        return Response.status(200).entity(s).build();
    }

    @GET
    @Path("/all")
    @Produces({MediaType.APPLICATION_JSON})
    public Response ListAllServers() {
        ServerDao serverDao = (ServerDao)SpringApplicationContext.getBean("serverDao");

        List<Server> serverList = serverDao.getAllServers();

        return Response.status(200).entity(serverList).build();
    }
}
