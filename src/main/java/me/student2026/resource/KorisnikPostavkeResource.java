package me.student2026.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import me.student2026.exception.ResourceNotFoundException;
import me.student2026.model.KorisnikPostavke;
import me.student2026.service.KorisnikPostavkeService;

import java.util.List;

@Path("/korisnik-postavke")
public class KorisnikPostavkeResource {

    @Inject
    KorisnikPostavkeService postavkeService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/addPostavke")
    public Response addPostavke(KorisnikPostavke postavke) {
        try {
            postavkeService.createPostavke(postavke);
        } catch (ResourceNotFoundException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        return Response.ok().build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAllPostavke")
    public Response getAllPostavke() {
        List<KorisnikPostavke> postavke = null;
        try {
            postavke = postavkeService.getAllPostavke();
        } catch (ResourceNotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
        return Response.ok().entity(postavke).build();
    }

    @GET
    @Path("/getPostavkeById")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPostavkeById(@QueryParam("id") Long id) {
        KorisnikPostavke postavke = postavkeService.getById(id);
        return Response.ok().entity(postavke).build();
    }
}
