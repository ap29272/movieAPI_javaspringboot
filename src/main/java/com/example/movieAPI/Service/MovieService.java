package com.example.movieAPI.Service;
import com.example.movieAPI.Models.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> Get();
    Movie GetById(Integer Id);
    Movie Create(Movie movie);
    void Update(Integer Id, Movie movie);
    void Delete(Integer Id);
}
