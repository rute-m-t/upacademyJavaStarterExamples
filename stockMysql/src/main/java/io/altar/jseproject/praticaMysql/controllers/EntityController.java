package io.altar.jseproject.praticaMysql.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import io.altar.jseproject.praticaMysql.models.Entity_;
import io.altar.jseproject.praticaMysql.models.DTOS.EntityDTO;
import io.altar.jseproject.praticaMysql.repositories.EntityRepository;
import io.altar.jseproject.praticaMysql.services.EntityService;

@Transactional
public abstract class EntityController<S extends EntityService<R,E,T>,R extends EntityRepository<E, T>,E extends Entity_<T>,T extends EntityDTO> {
 
	@Inject
	protected S service;
	
	@Context
	protected UriInfo context;
	
	@GET
	@Path("status")
	@Produces(MediaType.TEXT_PLAIN)
	public String status() {
		return "Url : " + context.getRequestUri().toString() + " is Ok";
	}
	
	@GET
	@Path("count")
	@Produces(MediaType.APPLICATION_JSON)
	public long count() {
		return service.size();
	}
	
	@GET
	@Path("allIds")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Long> getAllIds() {
		return service.getAllIds();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<T> getAll() {
		return service.getAll().stream().map(E::toDTO).collect(Collectors.toList());
	}
	
	@POST
	@Path("list")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String save(List<T> entitiesDTO) {
		entitiesDTO.forEach(entityDTO -> this.save(entityDTO));
		return "Done";
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response save(T entityDTO) {
		try {
			long currentId = service.create(toEntity(entityDTO));
			return Response.status(200).entity(currentId).build();
		} catch (UnsupportedOperationException e) {
			return Response.status(403).entity(e.getMessage()).build();
		} catch (Exception e) {
			return Response.status(400).entity(e.getMessage()).build();
		}
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(T entityDTO) {
		try {
			E entity = toEntity(entityDTO);
			service.update(entity);
			return Response.ok().build();
		} catch (UnsupportedOperationException e) {
			return Response.status(403).entity(e.getMessage()).build();
		} catch (Exception e) {
			return Response.status(400).entity(e.getMessage()).build();
		}
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(@PathParam("id") long id) {
		try {
			E entity = service.get(id);
			return Response.status(200).entity(entity.toDTO()).build();
		} catch (Exception e) {
			return Response.status(400).entity(e.getMessage()).build();
		}
	}
	
	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") long id) {
		try {
			service.delete(id);
			return Response.ok().build();
		} catch (UnsupportedOperationException e) {
			return Response.status(403).entity(e.getMessage()).build();
		} catch (Exception e) {
			return Response.status(400).entity(e.getMessage()).build();
		}
	}
	
	public abstract E toEntity(T entityDTO);
}
