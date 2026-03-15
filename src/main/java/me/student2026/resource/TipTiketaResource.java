package me.student2026.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import me.student2026.model.TipTiketa;
import me.student2026.service.TipTiketaService;

import java.util.List;

@Path("/tipovi-tiketa")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TipTiketaResource {

    @Inject
    TipTiketaService tipTiketaService;

    @POST
    public TipTiketa create(TipTiketa tipTiketa) {
        return tipTiketaService.createTipTiketa(tipTiketa);
    }

    @GET
    public List<TipTiketa> getAll() {
        return tipTiketaService.getAllTipoviTiketa();
    }
}