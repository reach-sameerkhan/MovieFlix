package io.movieflix.rest.repository;

import java.util.List;
import io.movieflix.rest.model.Movie;

public interface MovieRepository {
	public List<Movie> findAll(); 
	public Movie findOne(String id);
	public List<Movie> findByYear(int year);
	public List<Movie> findByActor(String actor);
	public Movie create(Movie movie);
	public Movie update(Movie movie);
	public void delete(Movie movie);
	
}
