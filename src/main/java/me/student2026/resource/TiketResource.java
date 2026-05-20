package me.student2026.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import me.student2026.exception.FileAlreadyExistsException;
import me.student2026.exception.ResourceNotFoundException;
import me.student2026.model.FileUploadForm;
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

    @POST
    @Path("/uploadFile")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public Response uploadFile(@QueryParam("tiketId") Long tiketId, FileUploadForm form) {
        try {
            Tiket tiket = tiketService.uploadFileToTiket(tiketId, form);
            return Response.ok(tiket).build();
        } catch (FileAlreadyExistsException e) {
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        } catch (ResourceNotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/getTiketWithFiles")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTiketWithFiles(@QueryParam("id") Long id) {
        try {
            Tiket tiket = tiketService.getTiketWithFiles(id);
            return Response.ok(tiket).build();
        } catch (ResourceNotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }
}
