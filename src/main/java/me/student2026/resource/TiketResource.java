package me.student2026.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import me.student2026.model.Tiket;
import me.student2026.service.TiketService;

import java.util.List;

@Path("/tiketi")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TiketResource {

    @Inject
    TiketService tiketService;

    @POST
    public Tiket create(Tiket tiket) {
        return tiketService.createTiket(tiket);
    }

    @GET
    public List<Tiket> getAll() {
        return tiketService.getAllTiketi();
    }
}
