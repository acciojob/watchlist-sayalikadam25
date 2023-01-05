package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Repository
public class MovieRepository {

    private HashMap<String, Movie> movieDb;
    private HashMap<String, Director> directorDb;
    private HashMap<String, List<String>> directorMoviesMap;
    private HashMap<String,String> movieDirectorMap;
    public MovieRepository(HashMap<String, Movie> movieDb, HashMap<String, Director> directorDb) {
        this.movieDb = new HashMap<>();
        this.directorDb = new HashMap<>();
        this.directorMoviesMap=new HashMap<>();
        this.movieDirectorMap=new HashMap<>();
    }
    public void addMovie(Movie movie){
        movieDb.put(movie.getName(),movie);
    }
    public void addDirector(Director director){
        directorDb.put(director.getName(), director);
    }
    public void addMovieDirectorPair(String movie, String director){
        if(movieDb.containsKey(movie) && directorDb.containsKey(director)){

            List<String> currentMoviesByDirector = new ArrayList<>();

            if(directorMoviesMap.containsKey(director))
                currentMoviesByDirector = directorMoviesMap.get(director);

            currentMoviesByDirector.add(movie);

            directorMoviesMap.put(director,currentMoviesByDirector);

        }
    }
    public Movie findMovie(String movie){
        return movieDb.get(movie);
    }
    public Director findDirector(String director){
        return directorDb.get(director);
    }
    public List<String> findMoviesFromDirector(String director){
        List<String> moviesList = new ArrayList<String>();
        if(directorMoviesMap.containsKey(director))
            moviesList = directorMoviesMap.get(director);
        return moviesList;
    }
    public List<String> findAllMovies(){

        return new ArrayList<>(movieDb.keySet());
    }
    public void deleteDirector(String director){

        List<String> movies = new ArrayList<String>();
        if(directorMoviesMap.containsKey(director)){
            movies = directorMoviesMap.get(director);
            for(String movie: movies){
                if(movieDb.containsKey(movie)){
                    movieDb.remove(movie);
                }
            }
            directorMoviesMap.remove(director);
        }
        if(directorDb.containsKey(director)){
            directorDb.remove(director);
        }
    }
    public void deleteAllDirectors(){

        HashSet<String> moviesSet = new HashSet<>();
        directorDb = new HashMap<>();
        for(String director: directorMoviesMap.keySet()){
            for(String movie: directorMoviesMap.get(director)){
                moviesSet.add(movie);
            }
        }
        for(String movie: moviesSet){
            if(movieDb.containsKey(movie)){
                movieDb.remove(movie);
            }
        }
        directorMoviesMap = new HashMap<>();
    }
    public void addDirectorMoviePair(String movie,String director){
        movieDirectorMap.put(movie,director);
    }
    public String getDirectorByMovieName(String searchMovie){
        for(String movie:movieDirectorMap.keySet()){
            if(searchMovie.equals(movie))
                return movieDirectorMap.get(movie);
        }
        return "Movie not found";
    }
}
