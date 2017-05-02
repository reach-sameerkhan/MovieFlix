package io.movieflix.rest.repository;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import io.movieflix.rest.model.Movie;

@Repository
public class MovieRepositoryImp implements MovieRepository{


	@PersistenceContext
	private EntityManager em;
	

	public List<Movie> findAll() {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findAll", Movie.class);
		return query.getResultList();	
	}

	public Movie findOne(String id) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findById", Movie.class);
		query.setParameter("pId", id);
		List<Movie> movie = query.getResultList();
		if(movie!=null && movie.size() == 1){
			return movie.get(0);
		}
		return null;
	}

	public List<Movie> findByYear(int year) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findByYear", Movie.class);
		query.setParameter("pYear", year);
		List<Movie> movie = query.getResultList();
		if(movie!=null){
			return movie;
		}
		return null;
	}
	
	public List<Movie> findByActor(String actor) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findByActor", Movie.class);
		query.setParameter("pActor", actor);
		List<Movie> movie = query.getResultList();
		if(movie!=null){
			return movie;
		}
		return null;
	}
	
	public Movie create(Movie movie) {
		em.persist(movie);
		return movie;	
	}

	public Movie update(Movie movie) {
		return em.merge(movie);
	}

	public void delete(Movie movie) {
		em.remove(movie);

	}

}
