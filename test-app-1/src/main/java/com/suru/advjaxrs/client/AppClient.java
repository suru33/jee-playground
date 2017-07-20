package com.suru.advjaxrs.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.suru.advjaxrs.model.User;

public class AppClient {

	public static void main(String[] args) {
		// getRequestType1();
		// getRequestType2();

		// postRequestTest();

		AppClient appClient = new AppClient();
		// get the invocation
		Invocation invocation = appClient.prepareGetRequestForUserById("09AJ502");
		// invoke the invocation 
		Response response = invocation.invoke();
		// reading response
		User user = response.readEntity(User.class);
		System.out.println(user);

	}

	public Invocation prepareGetRequestForUserById(String userId) {
		// creating the whole request
		String baseUri = "http://localhost:8080/test-app-1/webapi";
		Client client = ClientBuilder.newClient();
		WebTarget baseTarget = client.target(baseUri);
		WebTarget usersTarget = baseTarget.path("users");		
		WebTarget singleUserTarget = usersTarget.path("{userId}");
		
		// building request instead of requesting
		return singleUserTarget.resolveTemplate("userId", userId)
			.request(MediaType.APPLICATION_JSON)
			.buildGet();
	}

	private static void postRequestTest() {
		Client client = ClientBuilder.newClient();

		// request uri
		String baseUri = "http://localhost:8080/test-app-1/webapi";

		// base web target from client
		WebTarget baseTarget = client.target(baseUri);

		// users web target from base target
		WebTarget usersTarget = baseTarget.path("users");

		// build request from web target
		Builder builder = usersTarget.request();

		// post message data
		User user = new User("09AJ509", "jaxon", "page", 52, "WE22@@++");

		// posting the request
		// we can only send data as json or xml or text
		// we need to convert objec to JSON or XML entities
		Response postResponse = builder.post(Entity.json(user));

		// reading the response and convert to entity
		User readEntity = postResponse.readEntity(User.class);

		System.out.println("Status: " + postResponse.getStatus());
		System.out.println(readEntity);
	}

	private static void getRequestType2() {
		// creating new client from jax-rs
		Client client = ClientBuilder.newClient();

		// request uri
		String baseUri = "http://localhost:8080/test-app-1/webapi";

		// base web target from client
		WebTarget baseTarget = client.target(baseUri);

		// users web target from base target
		WebTarget usersTarget = baseTarget.path("users");

		// target for single user target from path placeholder
		WebTarget singleUserTarget = usersTarget.path("{userId}");

		// converting response as desired class
		User user = singleUserTarget.resolveTemplate("userId", "09AJ501").request(MediaType.APPLICATION_JSON)
				.get(User.class);

		System.out.println(user);

	}

	private static void getRequestType1() {
		// creating new client from jax-rs
		Client client = ClientBuilder.newClient();
		// request uri
		String uri = "http://localhost:8080/test-app-1/webapi/content_test";
		// web target from client
		WebTarget webTarget = client.target(uri);
		// building request with response type
		Builder builder = webTarget.request(MediaType.APPLICATION_JSON);
		// get response from web call
		Response response = builder.get();
		// reading data from response
		// we can convert response accordingly
		String data = response.readEntity(String.class);
		System.out.println(data);
	}

}
