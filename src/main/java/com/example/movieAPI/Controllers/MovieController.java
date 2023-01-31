package com.example.movieAPI.Controllers;
import com.example.movieAPI.Models.Movie;
import com.example.movieAPI.Service.MovieService;
import com.example.movieAPI.Service.StudioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/movie")
public class MovieController {
    private MovieService movieService;
    private StudioService studioService;

    MovieController(MovieService movieService, StudioService studioService){

        this.movieService = movieService;
        this.studioService = studioService;
    }

    @GetMapping
    public ResponseEntity<List<Movie>> Get() {
        List<Movie> movies = movieService.Get();
        if(movies == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping({"/{Id}"})
    public ResponseEntity<Movie> GetById(@PathVariable Integer Id) {
        Movie movie = movieService.GetById(Id);
        if(movie==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Movie> Create(@RequestBody Movie movie) {
        if(studioService.GetById(movie.getStudio().getId()) == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Movie creatingMovie = movieService.Create(movie);
        return new ResponseEntity<>(creatingMovie, HttpStatus.CREATED);
    }

    @PutMapping({"/{Id}"})
    public ResponseEntity<Movie> Update(@PathVariable("Id") Integer Id, @RequestBody Movie movie) {
        movieService.Update(Id, movie);
        return new ResponseEntity<>(movieService.GetById(Id), HttpStatus.OK);
    }
    //The function receives a DELETE request, deletes the Todo with the specified Id.
    @DeleteMapping({"/{Id}"})
    public ResponseEntity<Movie> Delete(@PathVariable("Id") Integer Id) {
        movieService.Delete(Id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}