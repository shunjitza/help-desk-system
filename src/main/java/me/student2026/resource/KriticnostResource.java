package me.student2026.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import me.student2026.model.Kriticnost;
import me.student2026.service.KriticnostService;

import java.util.List;

@Path("/kriticnosti")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class KriticnostResource {

    @Inject
    KriticnostService kriticnostService;

    @POST
    public Kriticnost create(Kriticnost kriticnost) {
        return kriticnostService.createKriticnost(kriticnost);
    }

    @GET
    public List<Kriticnost> getAll() {
        return kriticnostService.getAllKriticnosti();
    }
}