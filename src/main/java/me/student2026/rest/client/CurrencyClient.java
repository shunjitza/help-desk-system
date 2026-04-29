package me.student2026.rest.client;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import me.student2026.model.CurrencyResponse;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api")
@RegisterRestClient(configKey = "currency-api")
public interface CurrencyClient {
    @GET
    @Path("/rates")
    @Produces(MediaType.APPLICATION_JSON)
    CurrencyResponse getCurrency(@QueryParam("from") String from, @QueryParam("to") String to);
}