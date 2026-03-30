package me.student2026.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import me.student2026.exception.ResourceNotFoundException;
import me.student2026.model.Prilog;
import me.student2026.model.Tiket;
import me.student2026.service.TiketService;

import java.util.List;

@Path("/tiketi")
public class TiketResource {

    @Inject
    TiketService tiketService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/addTiket")
    public Response addTiket(Tiket tiket) {
        try {
            tiketService.createTiket(tiket);
        } catch (ResourceNotFoundException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        return Response.ok().build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAllTiketi")
    public Response getAllTiketi() {
        List<Tiket> tiketi = null;
        try {
            tiketi = tiketService.getAllTiketi();
        } catch (ResourceNotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
        return Response.ok().entity(tiketi).build();
    }

    @GET
    @Path("/getTiketByNaslov")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTiketByNaslov(@QueryParam("naslov") String naslov) {
        List<Tiket> tiketi = tiketService.getByNaslov(naslov);
        return Response.ok().entity(tiketi).build();
    }

    @GET
    @Path("/getTiketById")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTiketById(@QueryParam("id") Long id) {
        Tiket tiket = tiketService.getById(id);
        return Response.ok().entity(tiket).build();
    }

    @GET
    @Path("/getPriloziByTiketId")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPriloziByTiketId(@QueryParam("id") Long id) {
        List<Prilog> prilozi = tiketService.getPrilozi(id);
        return Response.ok().entity(prilozi).build();
    }
}
