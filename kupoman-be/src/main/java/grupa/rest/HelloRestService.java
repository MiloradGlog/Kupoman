package grupa.rest;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/test")
public class HelloRestService {
    @GET // This annotation indicates GET request

    @Produces(MediaType.TEXT_HTML)

    @Path("/hello")
    public Response hello() {
        return Response.
                status(200).entity("<h1>hellasdasdo</h1>").header("X-Content-Type-Options", "nosniff").build();
    }
}