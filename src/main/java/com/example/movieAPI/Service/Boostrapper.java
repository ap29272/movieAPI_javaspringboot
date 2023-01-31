package com.example.movieAPI.Service;
import com.example.movieAPI.Models.Category;
import com.example.movieAPI.Models.Movie;
import com.example.movieAPI.Models.Studio;
import com.example.movieAPI.Repository.IMovieRepository;
import com.example.movieAPI.Repository.IStudioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Boostrapper implements CommandLineRunner {
    public final IMovieRepository movieRepository;
    public final IStudioRepository studioRepository;

    Boostrapper(IMovieRepository movieRepository, IStudioRepository studioRepository){
        this.movieRepository = movieRepository;
        this.studioRepository = studioRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        LoadData();
    }

    private void LoadData(){
        if(studioRepository.count() == 0){
            studioRepository.save(
                    Studio.builder()
                            .Id(1)
                            .Name("20th Century Fox")
                            .Address("New York AD2")
                            .build()
            );
            studioRepository.save(
                    Studio.builder()
                            .Id(2)
                            .Name("LucasFilms")
                            .Address("Los Angeles 291")
                            .build()
            );
        }
        if(movieRepository.count() == 0){
            movieRepository.save(
                    Movie.builder()
                            .Title("Avatar")
                            .Description("Test description for Avatar")
                            .ReleaseDate(2013)
                            .Category(Category.Adventure)
                            .build()
            );
            movieRepository.save(
                    Movie.builder()
                            .Title("Avatar 2")
                            .Description("Test description for Avatar 2")
                            .ReleaseDate(2022)
                            .Category(Category.Adventure)
                            .build()
            );
        }
    }
}
