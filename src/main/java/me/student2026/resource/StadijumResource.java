package me.student2026.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import me.student2026.model.Stadijum;
import me.student2026.service.StadijumService;

import java.util.List;

@Path("/stadijumi")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StadijumResource {

    @Inject
    StadijumService stadijumService;

    @POST
    public Stadijum create(Stadijum stadijum) {
        return stadijumService.createStadijum(stadijum);
    }

    @GET
    public List<Stadijum> getAll() {
        return stadijumService.getAllStadijumi();
    }
}