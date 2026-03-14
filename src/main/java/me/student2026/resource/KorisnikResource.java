package me.student2026.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import me.student2026.model.Korisnik;
import me.student2026.service.KorisnikService;

import java.util.List;

@Path("/korisnici")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class KorisnikResource {

    @Inject
    KorisnikService korisnikService;

    @POST
    public Korisnik create(Korisnik korisnik) {
        return korisnikService.createKorisnik(korisnik);
    }

    @GET
    public List<Korisnik> getAll() {
        return korisnikService.getAllKorisnici();
    }
}
