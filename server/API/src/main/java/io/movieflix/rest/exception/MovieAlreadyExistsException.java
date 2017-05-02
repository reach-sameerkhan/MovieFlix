package io.movieflix.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.BAD_REQUEST) //for throwing specific status code in case of this exception. 

public class MovieAlreadyExistsException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	public MovieAlreadyExistsException(String message){
		super(message);
	}
	public MovieAlreadyExistsException(String message, Throwable cause){
		super(message,cause);
	}
}
