package me.student2026.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import me.student2026.exception.ResourceNotFoundException;
import me.student2026.model.Korisnik;
import me.student2026.service.KorisnikService;

import java.util.List;

@Path("/korisnici")
public class KorisnikResource {

    @Inject
    KorisnikService korisnikService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/addKorisnik")
    public Response addKorisnik(Korisnik korisnik) {
        try {
            korisnikService.createKorisnik(korisnik);
        } catch (ResourceNotFoundException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        return Response.ok().build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAllKorisnici")
    public Response getAllKorisnici() {
        List<Korisnik> korisnici = null;
        try {
            korisnici = korisnikService.getAllKorisnici();
        } catch (ResourceNotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
        return Response.ok().entity(korisnici).build();
    }

    @GET
    @Path("/getKorisnikByIme")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getKorisnikByIme(@QueryParam("ime") String ime) {
        List<Korisnik> korisnici = korisnikService.getByIme(ime);
        return Response.ok().entity(korisnici).build();
    }

    @GET
    @Path("/getKorisnikById")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getKorisnikById(@QueryParam("id") Long id) {
        Korisnik korisnik = korisnikService.getById(id);
        return Response.ok().entity(korisnik).build();
    }
}
