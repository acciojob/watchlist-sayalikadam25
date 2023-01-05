package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    MovieService movieService;

    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
        movieService.addMovie(movie);
        return new ResponseEntity<>("New movie added successfully", HttpStatus.CREATED);
    }

    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director){
        movieService.addDirector(director);
        return new ResponseEntity<>("New director added successfully", HttpStatus.CREATED);
    }

    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("movie") String movie, @RequestParam("director") String director){
        movieService.addMovieDirectorPair(movie, director);
        return new ResponseEntity<>("New movie-director pair added successfully", HttpStatus.CREATED);
    }

    @GetMapping("get-movie-by-name/{name}")
    public ResponseEntity<Movie> findMovie(@PathVariable String name){
        Movie movie= movieService.findMovie(name);
        return new ResponseEntity<>(movie,HttpStatus.CREATED);
    }

    @GetMapping("get-director-by-name/{name}")
    public ResponseEntity<Director> findDirector(@PathVariable String name){
        Director director=movieService.findDirector(name);
        return new ResponseEntity<>(director,HttpStatus.FOUND);
    }

    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable String director){
        List<String> movies = movieService.findMoviesFromDirector(director);
        return new ResponseEntity<>(movies, HttpStatus.CREATED);
    }
    @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>> getAllMovies(){
        List<String> movies=movieService.getAllMovies();
        return new ResponseEntity<>(movies,HttpStatus.FOUND);
    }

    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirector(@RequestParam String director){
        movieService.deleteDirector(director);
        return new ResponseEntity<>("removed successfully",HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllMovies(){
        movieService.deleteAllDirectors();
        return new ResponseEntity<>("removed successfully",HttpStatus.CREATED);
    }

}
