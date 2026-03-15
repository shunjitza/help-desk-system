package me.student2026.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import me.student2026.model.Prilog;
import me.student2026.service.PrilogService;

import java.util.List;

@Path("/prilozi")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PrilogResource {

    @Inject
    PrilogService prilogService;

    @POST
    public Prilog create(Prilog prilog) {
        return prilogService.createPrilog(prilog);
    }

    @GET
    public List<Prilog> getAll() {
        return prilogService.getAllPrilozi();
    }
}