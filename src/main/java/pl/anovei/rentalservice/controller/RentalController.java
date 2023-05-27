package pl.anovei.rentalservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import pl.anovei.rentalservice.model.Movie;
import pl.anovei.rentalservice.service.RentalService;

@RestController
public class RentalController {

    private final RentalService rentalService;

    @Autowired
    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @PutMapping("/rental/{id}/return")
    public ResponseEntity<Movie> returnMovie(@PathVariable Long id) {
        rentalService.returnMovie(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/rental/{id}/rent")
    public ResponseEntity<Movie> takeMovie(@PathVariable Long id) {
        rentalService.rentMovie(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/rental/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id) {
        Movie movie = rentalService.getMovie(id);

        if (movie != null) {
            return new ResponseEntity<>(movie, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
