package com.example.movieAPI;

import com.example.movieAPI.Models.Category;
import com.example.movieAPI.Models.Movie;
import com.example.movieAPI.Repository.IMovieRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class MovieApiApplicationTests {
	@Autowired
	private IMovieRepository movieRepository;

	@Test
	@Order(1)
	void getMovieList_DoesNotReturnNullWhenMoviesExist() throws Exception {
		List<Movie> movies = (List<Movie>) movieRepository.findAll();
		assertNotNull(movies);
	}

	@Test
	@Order(2)
	void getMovieById_DoesNotReturnNullWhenMovieExists() throws Exception {
		Movie movie = movieRepository.findById(1).get();
		assertNotNull(movie);
	}

	@Test
	@Order(3)
	void movieCreated() throws Exception {
		Movie movie = new Movie(4,
				"Avatar 4",
				"Test Description 123!@#",
				Category.Adventure,
				2030, null);
		movieRepository.save(movie);
		assertNotNull(movieRepository.findById(4));
	}

	@Test
	@Order(4)
	void movieUpdated() throws Exception {
		Movie movie = movieRepository.findById(1).get();
		movie.setTitle("Avatar 1");
		movieRepository.save(movie);
		assertNotEquals("Avatar", movieRepository.findById(1).get().getTitle());
	}

	@Test
	@Order(5)
	void movieDeleted() throws Exception {
		Movie movie = movieRepository.findById(1).get();
		movieRepository.delete(movie);
		assertNotNull(movieRepository.findById(1));
	}
}
