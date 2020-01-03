package io.altar.jseproject.praticaJaxrs.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

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

import io.altar.jseproject.praticaJaxrs.models.Entity_;
import io.altar.jseproject.praticaJaxrs.repositories.EntityRepository;
import io.altar.jseproject.praticaJaxrs.services.EntityService;


public abstract class EntityController<S extends EntityService<R,E>,R extends EntityRepository<E>,E extends Entity_> {
 
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
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<E> getAll() {
		return new ArrayList<E>(service.getAll());
	}
	
	@GET
	@Path("allIds")
	@Produces(MediaType.APPLICATION_JSON)
	public Set<Long> getAllIds() {
		return service.getAllIds();
	}
	
	@GET
	@Path("isEmpty")
	@Produces(MediaType.APPLICATION_JSON)
	public boolean isEmpty() {
		return service.isEmpty();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public long save(E entity) {
		long currentId = service.create(entity);
		return currentId;
	}
	
	@POST
	@Path("list")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String save(List<E> entities) {
		entities.forEach(entity -> this.save(entity));
		return "Done";
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(@PathParam("id") long id) {
		try {
			E entity = service.get(id);
			return Response.status(200).entity(entity).build();
		} catch (Exception e) {
			return Response.status(400).entity(e.getMessage()).build();
		}
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(E entity) {
		try {
			service.update(entity);
			return Response.ok().build();
		} catch (Exception e) {
			return Response.status(400).entity(e.getMessage()).build();
		}
	}
	
	@DELETE
	@Path("/{id}")
	public void delete(@PathParam("id") long id) {
		service.delete(id);
	}
}
