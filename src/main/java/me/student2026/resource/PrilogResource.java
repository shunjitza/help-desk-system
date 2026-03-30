package me.student2026.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import me.student2026.exception.ResourceNotFoundException;
import me.student2026.model.Prilog;
import me.student2026.service.PrilogService;

import java.util.List;

@Path("/prilozi")
public class PrilogResource {

    @Inject
    PrilogService prilogService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/addPrilog")
    public Response addPrilog(Prilog prilog) {
        try {
            prilogService.createPrilog(prilog);
        } catch (ResourceNotFoundException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        return Response.ok().build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAllPrilozi")
    public Response getAllPrilozi() {
        List<Prilog> prilozi = null;
        try {
            prilozi = prilogService.getAllPrilozi();
        } catch (ResourceNotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
        return Response.ok().entity(prilozi).build();
    }

    @GET
    @Path("/getPrilogByNazivFajla")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPrilogByNazivFajla(@QueryParam("nazivFajla") String nazivFajla) {
        List<Prilog> prilozi = prilogService.getByNazivFajla(nazivFajla);
        return Response.ok().entity(prilozi).build();
    }

    @GET
    @Path("/getPrilogById")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPrilogById(@QueryParam("id") Long id) {
        Prilog prilog = prilogService.getById(id);
        return Response.ok().entity(prilog).build();
    }
}
