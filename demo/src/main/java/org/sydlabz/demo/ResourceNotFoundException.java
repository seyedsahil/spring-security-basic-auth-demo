package org.sydlabz.demo;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException() {
		super();
	}

	public ResourceNotFoundException(int id) {
		super("Resource '" + Resource.class.getSimpleName().toLowerCase() + "' with unique id '" + id
				+ "' does not exist.");
	}

}
