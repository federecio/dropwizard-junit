package io.federecio.dropwizard.junitrunner;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * @author Federico Recio
 */
@Path("/test")
public class TestResource {

    @GET
    public Response dummy() {
        return Response.ok().build();
    }
}
