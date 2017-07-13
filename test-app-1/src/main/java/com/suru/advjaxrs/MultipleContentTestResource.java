package com.suru.advjaxrs;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.suru.advjaxrs.model.User;

@Path("content_test")
public class MultipleContentTestResource {

	@GET
	@Produces(value = { MediaType.TEXT_XML, MediaType.APPLICATION_JSON })
	public User getUserDetails() {
		return new User("09AJ533", "Jammy", "Fox", 33, "XRE34@@#d");
	}

	@POST
	@Produces(value = { MediaType.TEXT_XML, MediaType.APPLICATION_JSON })
	@Consumes(value = { MediaType.TEXT_XML, MediaType.APPLICATION_JSON })
	public User postUser(User user) {
		user.setMessage("post Message");
		return user;
	}
}
