package com.suru.advjaxrsapp2.providers;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.ext.Provider;

@Provider
@PreMatching
public class TestingRequestFilter implements ContainerRequestFilter {

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		requestContext.getHeaders().add("head-x", "ContainerRequestFilter");
		try {
			requestContext.setRequestUri(new URI("http://localhost:8080/jaxrs-test-app-2/webapi/test/redirect"));
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}

}
