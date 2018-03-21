package com.ait.racing;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/horses")
@Stateless
@LocalBean
public class RaceWS {

	@EJB
	private RaceDAO rDao;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllHorses() {
		List<RaceHorse> horses = rDao.getAllHorses();
		return Response.status(200).entity(horses).build();
	}	

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/{id}")
	public Response getHorseById(@PathParam("id") int id) {
		RaceHorse horse = rDao.getHorse(id);
		return Response.status(200).entity(horse).build();
	}	
	
	
	
	//---------------------------------------------
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/search/{name}")
	public Response getHorseByName(@PathParam("name") String name) {
		List<RaceHorse> horses = rDao.getHorseByName(name);
		return Response.status(200).entity(horses).build();
	}	
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/searchByOwner/{owner}")
	public Response getHorseByOwner(@PathParam("owner") String owner) {
		List<RaceHorse> horses = rDao.getHorseByOwner(owner);
		return Response.status(200).entity(horses).build();
	}	
	
	
}

