package io.movieflix.rest.service;

import java.util.List;

import io.movieflix.rest.model.Movie;

public interface MovieService {
	public List<Movie> findAll();
	public Movie findOne(String id);
	public List<Movie> findByYear(int year);
	public List<Movie> findByActor(String actor);
	public Movie create(Movie movie);
	public Movie update(String id, Movie movie);
	public void delete(String id);
}
