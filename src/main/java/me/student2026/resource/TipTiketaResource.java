package me.student2026.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import me.student2026.exception.ResourceNotFoundException;
import me.student2026.model.TipTiketa;
import me.student2026.service.TipTiketaService;

import java.util.List;

@Path("/tipovi-tiketa")
public class TipTiketaResource {

    @Inject
    TipTiketaService tipTiketaService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/addTipTiketa")
    public Response addTipTiketa(TipTiketa tipTiketa) {
        try {
            tipTiketaService.createTipTiketa(tipTiketa);
        } catch (ResourceNotFoundException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        return Response.ok().build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAllTipoviTiketa")
    public Response getAllTipoviTiketa() {
        List<TipTiketa> tipoviTiketa = null;
        try {
            tipoviTiketa = tipTiketaService.getAllTipoviTiketa();
        } catch (ResourceNotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
        return Response.ok().entity(tipoviTiketa).build();
    }

    @GET
    @Path("/getTipTiketaByNaziv")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTipTiketaByNaziv(@QueryParam("naziv") String naziv) {
        List<TipTiketa> tipoviTiketa = tipTiketaService.getByNaziv(naziv);
        return Response.ok().entity(tipoviTiketa).build();
    }

    @GET
    @Path("/getTipTiketaById")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTipTiketaById(@QueryParam("id") Long id) {
        TipTiketa tipTiketa = tipTiketaService.getById(id);
        return Response.ok().entity(tipTiketa).build();
    }
}
