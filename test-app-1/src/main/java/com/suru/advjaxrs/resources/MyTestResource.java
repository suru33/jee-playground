package com.suru.advjaxrs.resources;

import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("test")
public class MyTestResource {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String testResult() {
		return "Got it!";
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/date")
	public Date getDate() {
		return new Date();
	}
}
