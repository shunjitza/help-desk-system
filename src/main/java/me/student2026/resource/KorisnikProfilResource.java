package me.student2026.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import me.student2026.exception.ResourceNotFoundException;
import me.student2026.model.KorisnikProfil;
import me.student2026.service.KorisnikProfilService;

import java.util.List;

@Path("/korisnik-profil")
public class KorisnikProfilResource {

    @Inject
    KorisnikProfilService profilService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/addProfil")
    public Response addProfil(KorisnikProfil profil) {
        try {
            profilService.createProfil(profil);
        } catch (ResourceNotFoundException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        return Response.ok().build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAllProfili")
    public Response getAllProfili() {
        List<KorisnikProfil> profili = null;
        try {
            profili = profilService.getAllProfili();
        } catch (ResourceNotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
        return Response.ok().entity(profili).build();
    }

    @GET
    @Path("/getProfilByKorisnikId")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProfilByKorisnikId(@QueryParam("korisnikId") Long korisnikId) {
        KorisnikProfil profil = profilService.getByKorisnikId(korisnikId);
        return Response.ok().entity(profil).build();
    }

    @GET
    @Path("/getProfilById")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProfilById(@QueryParam("id") Long id) {
        KorisnikProfil profil = profilService.getById(id);
        return Response.ok().entity(profil).build();
    }
}
