
package org.sydlabz.demo;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/demo/list")
public class ResourceController {

	@Autowired
	private ResourceRepository resourceRepository;

	@Autowired
	private ResourceModelAssembler resourceModelAssembler;

	public ResourceController() {
		super();
	}

	@GetMapping("/resources")
	public CollectionModel<EntityModel<Resource>> getResources() {
		List<EntityModel<Resource>> resourceList = resourceRepository.findAll().stream()
				.map(resourceModelAssembler::toModel).collect(Collectors.toList());
		return new CollectionModel<EntityModel<Resource>>(resourceList,
				linkTo(methodOn(ResourceController.class).getResources()).withSelfRel());
	}

	@GetMapping("/resources/{id}")
	public EntityModel<Resource> getResource(@PathVariable(name = "id") Integer id) {
		Resource resource = resourceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
		return resourceModelAssembler.toModel(resource);
	}

}