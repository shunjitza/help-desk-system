package me.student2026.service;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import me.student2026.exception.ResourceNotFoundException;
import me.student2026.model.VrijemeResponse;
import me.student2026.rest.client.WeatherClient;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;

@Dependent
public class VrijemeService {

    @Inject
    private EntityManager em;

    @Inject
    @RestClient
    WeatherClient weatherClient;

    @Transactional
    public VrijemeResponse getForecast(String city) throws ResourceNotFoundException {
        if (city == null || city.isEmpty()) {
            throw new ResourceNotFoundException("Grad nije proslijedjen");
        }

        List<VrijemeResponse> existing = em.createQuery(
                        "SELECT v FROM VrijemeResponse v WHERE v.grad = :grad", VrijemeResponse.class)
                .setParameter("grad", city)
                .getResultList();

        if (!existing.isEmpty()) {
            throw new ResourceNotFoundException("Podaci za grad " + city + " već postoje u bazi.");
        }

        VrijemeResponse response = weatherClient.getWeatherByCity(city);
        if (response == null) {
            throw new ResourceNotFoundException("Nije moguće dobiti podatke o vremenu za grad " + city);
        }

        response.setGrad(city);
        return em.merge(response);
    }
}
