package io.movieflix.rest.controller;
//test changes to check if push from eclipse git is working
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.movieflix.rest.model.Movie;
import io.movieflix.rest.service.MovieService;

@RestController
@RequestMapping(path = "movies")
public class MovieController {
	
	@Autowired
	MovieService service;
	
	@RequestMapping(method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> findAll(){
		return service.findAll();
	}
	
	@RequestMapping(method=RequestMethod.GET, path="{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie findOne(@PathVariable("id") String id){
		return service.findOne(id);
	} 
	
	@RequestMapping(method=RequestMethod.GET, path="year/{year}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> findByYear(@PathVariable("year") int year){
		return service.findByYear(year);
	} 
	
	@RequestMapping(method=RequestMethod.GET, path="actor/{actor}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> findByActor(@PathVariable("actor") String actor){
		return service.findByActor(actor);
	} 
	
	@RequestMapping(method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie create(@RequestBody Movie movie){
		return service.create(movie);
	}
	
	@RequestMapping(method=RequestMethod.PUT, path="{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie update(@PathVariable("id") String id, @RequestBody Movie movie){
		return service.update(id, movie);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, path="{id}")
	public void delete(@PathVariable("id") String id){
		service.delete(id);
	}
	

}
