package com.example.movieAPI.Service;
import com.example.movieAPI.Models.Movie;
import com.example.movieAPI.Repository.IMovieRepository;
import com.example.movieAPI.Repository.IStudioRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceIMP implements MovieService {
    IMovieRepository movieRepository;
    IStudioRepository studioRepository;
    MovieServiceIMP(IMovieRepository movieRepository, IStudioRepository studioRepository){
        this.movieRepository = movieRepository;
        this.studioRepository = studioRepository;
    }

    @Override
    public List<Movie> Get() {
        List<Movie> movies = new ArrayList<>();
        movieRepository.findAll().forEach(movies::add);
        return movies;
    }

    @Override
    public Movie GetById(Integer Id) {
        return movieRepository.findById(Id).get();
    }

    @Override
    public Movie Create(Movie movie) {
        var studio = studioRepository.findById(movie.getStudio().getId());
        return movieRepository.save(movie);
    }

    @Override
    public void Update(Integer Id, Movie movie) {
        Movie currentMovie = movieRepository.findById(Id).get();
        currentMovie.setTitle(movie.getTitle());
        currentMovie.setDescription(movie.getDescription());
        currentMovie.setReleaseDate(movie.getReleaseDate());
        currentMovie.setCategory(movie.getCategory());

        movieRepository.save(currentMovie);
    }

    @Override
    public void Delete(Integer Id) {
        movieRepository.deleteById(Id);
    }
}

