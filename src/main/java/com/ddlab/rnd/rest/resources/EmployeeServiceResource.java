package com.ddlab.rnd.rest.resources;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;

import com.ddlab.rest.entity.ServerResponse;
import com.ddlab.rest.entity.User;
import com.ddlab.rest.service.EmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Path("1/empservice")
@Api(value="/empservice",tags={"empservice"})
public class EmployeeServiceResource extends BaseResource {

	@Context
	HttpServletRequest request;

	@Context
	ServletConfig servletConfig;

	@Autowired
	private EmployeeService empService;

	@Path("/create")
	@POST
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON , MediaType.TEXT_PLAIN})
	@ApiOperation(value="Create a user", notes="used to create a user",code=200)
	@ApiResponses(value={
            @ApiResponse(code=200, message="OK"),
            @ApiResponse(code=500, message="Internal Error")
    })
	public Response createUser(User user) {
		ResponseBuilder responseBuilder = null;
		try {
			if(user.getUserName() == null || user.getPassword() == null )
				responseBuilder = Response.status(Status.BAD_REQUEST).entity("Incorrect password").header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
			empService.createUser(user);
			responseBuilder = Response.status(Status.CREATED).entity(new ServerResponse("Success", "User created successfully"));
		} catch (Exception e) {
			responseBuilder = Response.serverError();
		}
		return responseBuilder.build();
	}

	@Path("/update")
	@PUT
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@ApiOperation(value="Update a user", notes="used to update a user")
	public Response updateUser(User user) {
		ResponseBuilder responseBuilder = null;
		if(user.getUserName() == null || user.getPassword() == null )
			throw createWebappException(new IllegalArgumentException("Incorrect credentials"));
		empService.updateUser(user);
		responseBuilder = Response.ok(new ServerResponse("Success", "User updated successfully"));
		return responseBuilder.build();
		
	}
	
	@Path("/delete")
	@DELETE
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@ApiOperation(value="Delete a user", notes="used to delete a user")
	public Response deleteUser(User user) { 
		ResponseBuilder responseBuilder = null;
		if(user.getUserName() == null || user.getPassword() == null )
			throw createWebappException(new IllegalArgumentException("Incorrect credentials"));
		empService.deleteUser(user);
		responseBuilder = Response.ok(new ServerResponse("Success", "User "+user.getUserName()+" has been removed from the system successfully"));
		return responseBuilder.build();
//		return "User "+user.getUserName()+" has been removed from the system successfully";
	}
	
	@Path("/userid")
	@GET
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@ApiOperation(value="get the user details", notes="Some notes", response=User.class)
	public User getUser(@QueryParam("id") int id) { //204 No content
		if(id == 0 )
			throw createWebappException(new IllegalArgumentException("Incorrect ID"));
		return empService.getUserById(String.valueOf(id));
	}
}
