package com.suru.advjaxrsapp2.providers;

import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.internal.util.Base64;

@Provider
public class SecurityFilter implements ContainerRequestFilter {

	private static final String SECURED_URL_PREFIX = "secured";
	private static final String AUTH_HEADER_KEY = "Authorization";
	private static final String AUTH_HEADER_PREFIX = "Basic ";

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		// checking URI has path "secured"
		if (requestContext.getUriInfo().getPath().contains(SECURED_URL_PREFIX)) {
			// getting request headers
			List<String> authHeader = requestContext.getHeaders().get(AUTH_HEADER_KEY);
			if (authHeader != null && !authHeader.isEmpty()) {
				// get the auth token
				String authToken = authHeader.get(0);
				// remove "Basic " text from the header value
				authToken = authToken.replaceFirst(AUTH_HEADER_PREFIX, "");
				// decode Base64 String
				String decodedString = Base64.decodeAsString(authToken);
				
				// format is username:password 
				// tokenize the decoded string  
				StringTokenizer tokenizer = new StringTokenizer(decodedString, ":");
				String userName = tokenizer.nextToken();
				String password = tokenizer.nextToken();

				// Authenticating user and password
				if ("suru".equals(userName) && "password".equals(password)) {
					return;
				}
			}
			
			// preparing the UNAUTHORIZED response
			Response unauthorizedStatus = Response
											.status(Status.UNAUTHORIZED)
											.entity("User cannot access this resource")
											.build();
			// aborting request
			requestContext.abortWith(unauthorizedStatus);
		}
	}
}
