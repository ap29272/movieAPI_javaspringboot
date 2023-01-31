package com.example.movieAPI.Service;
import com.example.movieAPI.Models.Movie;
import com.example.movieAPI.Models.Studio;
import com.example.movieAPI.Repository.IStudioRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudioServiceIMP implements StudioService {
    IStudioRepository studioRepository;
    StudioServiceIMP(IStudioRepository studioRepository){
        this.studioRepository = studioRepository;
    }

    @Override
    public List<Studio> Get() {
        List<Studio> studios = new ArrayList<>();
        this.studioRepository.findAll().forEach(studios::add);
        return studios;
    }

    @Override
    public Studio GetById(Integer Id) {
        return this.studioRepository.findById(Id).get();
    }

    @Override
    public Studio Create(Studio movie) {
        return this.studioRepository.save(movie);
    }

    @Override
    public void Update(Integer Id, Studio studio) {
        var currentStudio = studioRepository.findById(Id).get();
        currentStudio.setName(studio.getName());
        currentStudio.setAddress(studio.getAddress());

        this.studioRepository.save(currentStudio);
    }

    @Override
    public void Delete(Integer Id) {
        this.studioRepository.deleteById(Id);
    }
}