package net.javaci.lighthouse.frontend.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * User: ekocaman
 * Date: 4/22/13
 */
@Path("/process")
public class ProcessService {

    @GET
    @Path("/print")
    public Response printMessage() {
        return Response.status(200).entity("OK").build();
    }
}
