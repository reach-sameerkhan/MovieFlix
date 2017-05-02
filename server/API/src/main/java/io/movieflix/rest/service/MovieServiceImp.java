package io.movieflix.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.movieflix.rest.exception.MovieAlreadyExistsException;
import io.movieflix.rest.exception.MovieNotFoundException;
import io.movieflix.rest.model.Movie;
import io.movieflix.rest.repository.MovieRepository;

@Component
@Service
public class MovieServiceImp implements MovieService {

	@Autowired
	MovieRepository movieRepo;
	
	public List<Movie> findAll() {
		return movieRepo.findAll();
	}

	public Movie findOne(String id) {
		Movie existing = movieRepo.findOne(id);
		if(existing == null){
			throw new MovieNotFoundException("Movie "+id+" does not exist.");
		}
		return existing;	
	}

	public List<Movie> findByYear(int year){
		return movieRepo.findByYear(year);
	}
	
	public List<Movie> findByActor(String actor){
		return movieRepo.findByActor(actor);
	}
	
	@Transactional
	public Movie create(Movie movie) {
		if(movieRepo.findOne(movie.getImdb().getImdbId()) != null ){
			throw new MovieAlreadyExistsException("Movie with Imdb ID: "+movie.getImdb().getImdbId()+"  already exist.");
		}
		return movieRepo.create(movie); 
	}

	@Transactional
	public Movie update(String id, Movie movie) {
		if(movieRepo.findOne(id) == null ){
			throw new MovieNotFoundException("Movie "+id+" does not exist.");
		}
		return movieRepo.update(movie);	}

	@Transactional
	public void delete(String id) {
		Movie existing = movieRepo.findOne(id);
		if(existing == null ){
			throw new MovieNotFoundException("Movie "+id+" does not exist.");
		}
		movieRepo.delete(existing);
	}	
}
