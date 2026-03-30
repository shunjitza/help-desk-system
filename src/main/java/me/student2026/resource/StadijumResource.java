package me.student2026.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import me.student2026.exception.ResourceNotFoundException;
import me.student2026.model.Stadijum;
import me.student2026.service.StadijumService;

import java.util.List;

@Path("/stadijumi")
public class StadijumResource {

    @Inject
    StadijumService stadijumService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/addStadijum")
    public Response addStadijum(Stadijum stadijum) {
        try {
            stadijumService.createStadijum(stadijum);
        } catch (ResourceNotFoundException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        return Response.ok().build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAllStadijumi")
    public Response getAllStadijumi() {
        List<Stadijum> stadijumi = null;
        try {
            stadijumi = stadijumService.getAllStadijumi();
        } catch (ResourceNotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
        return Response.ok().entity(stadijumi).build();
    }

    @GET
    @Path("/getStadijumByNaziv")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStadijumByNaziv(@QueryParam("naziv") String naziv) {
        List<Stadijum> stadijumi = stadijumService.getByNaziv(naziv);
        return Response.ok().entity(stadijumi).build();
    }

    @GET
    @Path("/getStadijumById")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStadijumById(@QueryParam("id") Long id) {
        Stadijum stadijum = stadijumService.getById(id);
        return Response.ok().entity(stadijum).build();
    }
}
