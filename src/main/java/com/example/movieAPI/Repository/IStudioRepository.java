package com.example.movieAPI.Repository;

import com.example.movieAPI.Models.Studio;
import org.springframework.data.repository.CrudRepository;

public interface IStudioRepository extends CrudRepository<Studio, Integer> {
}
