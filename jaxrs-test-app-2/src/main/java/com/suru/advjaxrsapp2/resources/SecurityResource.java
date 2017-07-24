package com.suru.advjaxrsapp2.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("secured")
public class SecurityResource {

	@GET
	@Path("message")
	public String getSecuredMessage() {
		return "secured message";
	}
}
