package me.student2026.rest.client;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import me.student2026.model.VrijemeResponse;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/weather")
@RegisterRestClient(configKey = "weather-api")
public interface WeatherClient {

    @GET
    @Path("/{city}")
    @Produces(MediaType.APPLICATION_JSON)
    VrijemeResponse getWeatherByCity(@PathParam("city") String city);
}
