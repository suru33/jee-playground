package com.suru.advjaxrs.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import com.suru.advjaxrs.model.User;

public class GenericsTestClient {

	public static void main(String[] args) {
		// creating web client
		String baseUri = "http://localhost:8080/test-app-1/webapi";
		Client client = ClientBuilder.newClient();
		WebTarget baseTarget = client.target(baseUri);
		WebTarget usersTarget = baseTarget.path("users");

		// applying generic type
		List<User> list = usersTarget.request(MediaType.APPLICATION_JSON)
				.get(new GenericType<List<User>>() {});
		
		System.out.println(list);
	}
}
