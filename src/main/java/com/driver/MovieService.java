package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public void addMovie(Movie movie){
        movieRepository.addMovie(movie);
    }
    public void addDirector(Director director){
        movieRepository.addDirector(director);
    }
    public void addMovieDirectorPair(String movie, String director){
        movieRepository.addMovieDirectorPair(movie,director);
    }
    public Movie findMovie(String movie){
        return movieRepository.findMovie(movie);
    }
    public Director findDirector(String director){
        return findDirector(director);
    }
    public List<String> findMoviesFromDirector(String director){
        return movieRepository.findMoviesFromDirector(director);
    }
    public List<String> findAllMovies(){
        return movieRepository.findAllMovies();
    }
    public void deleteDirector(String director){
        movieRepository.deleteDirector(director);
    }
    public void deleteAllDirectors(){
        movieRepository.deleteAllDirectors();
    }
    public void addDirectorMoviePair(String movie,String director){
        movieRepository.addDirectorMoviePair(movie,director);
    }
    public String getDirectorByMovieName(String movie){
        return movieRepository.getDirectorByMovieName(movie);
    }
}
