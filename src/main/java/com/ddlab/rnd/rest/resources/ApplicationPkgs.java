package com.ddlab.rnd.rest.resources;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.jackson.JacksonFeature;

public class ApplicationPkgs extends Application {
	
	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> resources = new HashSet<Class<?>>();
		resources.add(EmployeeServiceResource.class);
		resources.add(JacksonFeature.class);
		
		//For swagger
		resources.add(io.swagger.jaxrs.listing.ApiListingResource.class);
        resources.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);

		
		
		return resources;
	}
}
