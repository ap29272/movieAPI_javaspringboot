package com.example.movieAPI.Controllers;
import com.example.movieAPI.Models.Movie;
import com.example.movieAPI.Models.Studio;
import com.example.movieAPI.Service.StudioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/studio")
public class StudioController {
    private StudioService studioService;
    StudioController(StudioService studioService){
        this.studioService = studioService;
    }

    @GetMapping
    public ResponseEntity<List<Studio>> Get() {
        List<Studio> studios = studioService.Get();
        if(studios == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(studios, HttpStatus.OK);
    }

    @GetMapping({"/{Id}"})
    public ResponseEntity<Studio> GetById(@PathVariable Integer Id) {
        Studio studio = studioService.GetById(Id);
        if(studio==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(studio, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Studio> Create(@RequestBody Studio studio) {
        Studio creatingStudio = studioService.Create(studio);
        return new ResponseEntity<>(creatingStudio, HttpStatus.CREATED);
    }

    @PutMapping({"/{Id}"})
    public ResponseEntity<Studio> Update(@PathVariable("Id") Integer Id, @RequestBody Studio studio) {
        studioService.Update(Id, studio);
        return new ResponseEntity<>(studioService.GetById(Id), HttpStatus.OK);
    }

    @DeleteMapping({"/{Id}"})
    public ResponseEntity<Studio> Delete(@PathVariable("Id") Integer Id) {
        studioService.Delete(Id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

//    @GetMapping("{studioId, movieId}")
//    public void AddMovie(@PathVariable("studioId") Integer sId, @PathVariable("movieId") Integer mId){
//
//    }
}