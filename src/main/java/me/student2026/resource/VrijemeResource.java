package me.student2026.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import me.student2026.exception.ResourceNotFoundException;
import me.student2026.model.VrijemeResponse;
import me.student2026.service.VrijemeService;

@Path("/vrijeme")
public class VrijemeResource {

    @Inject
    VrijemeService vrijemeService;

    @GET
    @Path("/getforecast")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getForecast(@QueryParam("city") String city) {
        try {
            VrijemeResponse response = vrijemeService.getForecast(city);
            return Response.ok(response).build();
        } catch (ResourceNotFoundException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }
}
