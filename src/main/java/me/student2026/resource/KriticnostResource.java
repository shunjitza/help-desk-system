package me.student2026.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import me.student2026.exception.ResourceNotFoundException;
import me.student2026.model.Kriticnost;
import me.student2026.service.KriticnostService;

import java.util.List;

@Path("/kriticnosti")
public class KriticnostResource {

    @Inject
    KriticnostService kriticnostService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/addKriticnost")
    public Response addKriticnost(Kriticnost kriticnost) {
        try {
            kriticnostService.createKriticnost(kriticnost);
        } catch (ResourceNotFoundException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        return Response.ok().build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAllKriticnosti")
    public Response getAllKriticnosti() {
        List<Kriticnost> kriticnosti = null;
        try {
            kriticnosti = kriticnostService.getAllKriticnosti();
        } catch (ResourceNotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
        return Response.ok().entity(kriticnosti).build();
    }

    @GET
    @Path("/getKriticnostByNaziv")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getKriticnostByNaziv(@QueryParam("naziv") String naziv) {
        List<Kriticnost> kriticnosti = kriticnostService.getByNaziv(naziv);
        return Response.ok().entity(kriticnosti).build();
    }

    @GET
    @Path("/getKriticnostById")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getKriticnostById(@QueryParam("id") Long id) {
        Kriticnost kriticnost = kriticnostService.getById(id);
        return Response.ok().entity(kriticnost).build();
    }
}
