package net.javaci.lighthouse.frontend.rest;

import javax.ws.rs.Path;

/**
 * User: ekocaman
 * Date: 4/22/13
 */
@Path("/server")
public class ServerService {

//    @GET
//    @Path("/print")
//    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
//    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
//    public Response printMessage() {
//        Server s = new Server();
//
//        return Response.status(200).entity(s).build();
//    }
//
//    @GET
//    @Path("/all")
//    @Produces({MediaType.APPLICATION_JSON})
//    public Response ListAllServers() {
//        ServerDao serverDao = (ServerDao)SpringApplicationContext.getBean("serverDao");
//
//        List<Server> serverList = serverDao.getAllServers();
//
//        return Response.status(200).entity(serverList).build();
//    }
}
