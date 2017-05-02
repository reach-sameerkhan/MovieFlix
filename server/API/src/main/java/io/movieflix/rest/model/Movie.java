package io.movieflix.rest.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
@NamedQueries({
	@NamedQuery(name="Movie.findAll", query="SELECT m FROM Movie m ORDER BY m.title ASC"),
	@NamedQuery(name="Movie.findById", query="SELECT m FROM Movie m WHERE m.id=:pId"),
	@NamedQuery(name="Movie.findByYear", query="SELECT m FROM Movie m WHERE m.year=:pYear ORDER BY m.title ASC"),
	@NamedQuery(name="Movie.findByActor", query="SELECT m FROM Movie m WHERE m.actor=:pActor ORDER BY m.title ASC")
})
public class Movie {
	@Id
	@GenericGenerator(name="customUUID", strategy="uuid2")
	@GeneratedValue(generator="customUUID")
	private String id;
	
	private String title;
	private int year;
	private String rated;
	private Date released;
	private String runtime;
	private String genre;
	private String director;
	private String writer;
	private String actor;
	private String plot;
	private String language;
	private String country;
	private String awards;
	private String poster;
	private int metascore;
	
	@OneToOne
	private Imdb imdb;
	
	private String type;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getRated() {
		return rated;
	}

	public void setRated(String rated) {
		this.rated = rated;
	}

	public Date getReleased() {
		return released;
	}

	public void setReleased(Date released) {
		this.released = released;
	}

	public String getRuntime() {
		return runtime;
	}

	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public String getPlot() {
		return plot;
	}

	public void setPlot(String plot) {
		this.plot = plot;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAwards() {
		return awards;
	}

	public void setAwards(String awards) {
		this.awards = awards;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public int getMetascore() {
		return metascore;
	}

	public void setMetascore(int metascore) {
		this.metascore = metascore;
	}

	public Imdb getImdb() {
		return imdb;
	}

	public void setImdb(Imdb imdb) {
		this.imdb = imdb;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", year=" + year + ", rated=" + rated + ", released=" + released
				+ ", runtime=" + runtime + ", genre=" + genre + ", director=" + director + ", writer=" + writer
				+ ", actor=" + actor + ", plot=" + plot + ", language=" + language + ", country=" + country
				+ ", awards=" + awards + ", poster=" + poster + ", metascore=" + metascore + ", imdb=" +imdb
				+ ", type=" + type + "]";
	}


	
}

