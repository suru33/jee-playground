package com.suru.testws.messanger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("injection_test")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectionTestResource {

	@GET
	@Path("/annotations")
	public String testInjection(@MatrixParam("mParam") String mParam, 
								@QueryParam("qParam") String qParam,
								@CookieParam("cParam") String cParam,
								@HeaderParam("hParam") String hParam) {
		String result = "Marrix Param: " + mParam;
		result += "\nQuery Param: " + qParam;
		result += "\nCookie Param: " + cParam;
		result += "\nHeader Param: " + hParam;
		return result;
	}
	
	
	public void testContext(@Context UriInfo info, @Context HttpHeaders headers) {
		System.out.println(info);
		System.out.println(headers);
	}
}
