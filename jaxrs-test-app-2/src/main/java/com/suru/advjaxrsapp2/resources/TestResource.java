package com.suru.advjaxrsapp2.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

@Path("test")
public class TestResource {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String test(@Context HttpHeaders headers) {
		String head = headers.getHeaderString("head-x");
		return "test data from resource >>> " + "head: " + head;
	}

	@GET
	@Path("/redirect")
	@Produces(MediaType.TEXT_PLAIN)
	public String redirectTest() {
		return "redirection successfull with filter";
	}
}
