package me.student2026.rest.client;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import me.student2026.model.TimezoneResponse;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api/time/current")
@RegisterRestClient(configKey = "timezone-api")
public interface TimezoneClient {

    @GET
    @Path("/ip")
    @Produces(MediaType.APPLICATION_JSON)
    TimezoneResponse getTimezoneByIp(@QueryParam("ipAddress") String ipAddress);
}