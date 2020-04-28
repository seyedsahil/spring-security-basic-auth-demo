package org.sydlabz.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class ResourceExceptionAdvice {

	@ResponseBody
	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String resourceNotFoundHandler(ResourceNotFoundException ex) {
		return ex.getMessage();
	}

}
