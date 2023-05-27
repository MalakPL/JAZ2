package pl.anovei.rentalservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.anovei.rentalservice.model.Movie;

@Service
public class RentalService {

    public RestTemplate restTemplate;

    @Autowired
    public RentalService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Movie getMovie(Long id) {
        return restTemplate.getForObject("http://localhost:8080/movies/{id}", Movie.class, id);
    }

    public void returnMovie(Long id) {
        restTemplate.put("http://localhost:8080/movies/{id}/set_available/true", HttpEntity.EMPTY, id);
    }

    public void rentMovie(Long id) {
        restTemplate.put("http://localhost:8080/movies/{id}/set_available/false", HttpEntity.EMPTY, id);
    }
}
