package org.sydlabz.demo;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class ResourceModelAssembler implements RepresentationModelAssembler<Resource, EntityModel<Resource>> {

	@Override
	public EntityModel<Resource> toModel(Resource resource) {
		return new EntityModel<Resource>(resource,
				linkTo(methodOn(ResourceController.class).getResource(resource.getId())).withSelfRel(),
				linkTo(methodOn(ResourceController.class).getResources()).withRel("resources"));
	}

}
