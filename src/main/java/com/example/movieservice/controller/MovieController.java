package com.example.movieservice.controller;

import com.example.movieservice.model.Movie;
import com.example.movieservice.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movieService")
public class MovieController {

    public final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/findAllMovies")
    public ResponseEntity<List<Movie>> showAllMovies(){
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    @GetMapping("/movies/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable long id){
        return ResponseEntity.ok(movieService.findMovieById(id));
    }

    @PostMapping("/addMovie")
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie){
        if (movie != null){
            movieService.save(movie);
            return ResponseEntity.ok(movie);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/movies/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable Long id, @RequestBody Movie movie){
        if (getMovieById(id) != null) {
            movie.setId(id);
            movieService.updateMovie(movie);
            return ResponseEntity.ok(movie);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/movies/{id}")
    public ResponseEntity<Void> deletingMovie(@PathVariable Long id){
        if (getMovieById(id) != null){
            movieService.deleteMovie(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/movies/setUnavailable/{id}")
    public ResponseEntity<Movie> setUnavailable(@PathVariable Long id) {
        Movie movie = movieService.findMovieById(id);
        if (movie != null) {
            movieService.setStatusUnavailable(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}