package com.suru.testws.messanger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

import com.suru.testws.messanger.benas.ExceptionMessage;


public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {

	@Override
	public Response toResponse(DataNotFoundException ex) {
		ExceptionMessage exceptionMessage = new ExceptionMessage(ex.getMessage(), 500, "http://www.texmp.com");
		return Response.status(Status.NOT_FOUND).entity(exceptionMessage).build();
	}
}
