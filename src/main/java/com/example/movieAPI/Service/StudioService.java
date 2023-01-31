package com.example.movieAPI.Service;

import com.example.movieAPI.Models.Studio;

import java.util.List;

public interface StudioService {

    List<Studio> Get();
    Studio GetById(Integer Id);
    Studio Create(Studio movie);
    void Update(Integer Id, Studio movie);
    void Delete(Integer Id);
}
