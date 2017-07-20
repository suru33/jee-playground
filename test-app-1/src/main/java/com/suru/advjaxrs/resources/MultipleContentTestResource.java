package com.suru.advjaxrs.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.suru.advjaxrs.model.User;

@Path("users")
public class MultipleContentTestResource {

	@GET
	@Produces(value = { MediaType.TEXT_XML, MediaType.APPLICATION_JSON })
	public List<User> getUserDetails() {
		List<User> users = new ArrayList<>();
		users.add(new User("09AJ501", "Jim", "Bay", 22, "AD@DS34"));
		users.add(new User("09AJ502", "Perry", "Jak", 28, "A225@EE"));
		users.add(new User("09AJ503", "Moan", "Sul", 26, "D%%@56"));
		users.add(new User("09AJ504", "Jammy", "Fox", 33, "XRE34@@#d"));
		return users;
	}

	@GET
	@Path("{userId}")
	@Produces(value = { MediaType.TEXT_XML, MediaType.APPLICATION_JSON })
	public User getUserDetails(@PathParam("userId") String userId) {
		switch (userId) {
		case "09AJ501":
			return new User(userId, "Jim", "Bay", 22, "AD@DS34");
		case "09AJ502":
			return new User(userId, "Perry", "Jak", 28, "A225@EE");
		case "09AJ503":
			return new User(userId, "Moan", "Sul", 26, "D%%@56");
		case "09AJ504":
			return new User(userId, "Ova", "White", 20, "GFD@##14");
		default:
			return null;
		}
	}

	@POST
	@Produces(value = { MediaType.TEXT_XML, MediaType.APPLICATION_JSON })
	@Consumes(value = { MediaType.TEXT_XML, MediaType.APPLICATION_JSON })
	public Response postUser(User user) {
		user.setMessage("message received and edited by post resource");
		return Response.status(Status.CREATED).entity(user).build();
	}
}
