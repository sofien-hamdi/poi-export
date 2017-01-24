package com.kt.examples.rs.export;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/items")
public interface ItemService {
  
  @GET
  @Path("/")
  @Produces("application/stream")
  public Response getItems(); 

}
