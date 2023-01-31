package com.example.movieAPI.Repository;

import com.example.movieAPI.Models.Movie;
import org.springframework.data.repository.CrudRepository;

public interface IMovieRepository extends CrudRepository<Movie, Integer> {
}
