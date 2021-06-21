package business;


import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import beans.Bible;


@RequestScoped
@Path("/bible")
public class WordSearchRestService {

	@Inject
	WordSearchBusinessInterface service;
	
	@GET
	@Path("/getjson")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Bible> getBibleAsJson(){
		List<Bible> list = new ArrayList<Bible>();
		list.add(service.getBible());
		return list;
	}
}
