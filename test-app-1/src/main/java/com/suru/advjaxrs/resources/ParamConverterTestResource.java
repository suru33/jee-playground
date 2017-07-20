package com.suru.advjaxrs.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.suru.advjaxrs.model.MyDate;

@Path("date/{dateParam}")
public class ParamConverterTestResource {

	@GET
	@Produces(MediaType.TEXT_XML)
	public MyDate getDate(@PathParam("dateParam") MyDate myDate) {
		return myDate; 
	}
}
