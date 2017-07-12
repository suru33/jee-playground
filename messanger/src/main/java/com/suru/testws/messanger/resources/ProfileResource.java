package com.suru.testws.messanger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.suru.testws.messanger.model.Profile;
import com.suru.testws.messanger.services.ProfileService;

@Path("/profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {

	private ProfileService profileService = new ProfileService();

	public ProfileResource() {
	}

	@GET
	public List<Profile> getAllMessages() {
		return profileService.getAllProfiles();
	}

	@POST
	public Profile addMessage(Profile profile) {
		return profileService.addProfile(profile);
	}

	@GET
	@Path("/{profileId}")
	public Profile getProfile(@PathParam("profileId") String profileId) {
		return profileService.getProfile(profileId);
	}

	@PUT
	@Path("/{profileId}")
	public Profile updateMessage(@PathParam("profileId") String profileId, Profile profile) {
		profile.setProfileId(profileId);
		return profileService.updateProfile(profile);
	}

	@DELETE
	@Path("/{profileId}")
	public Profile deleteMessage(@PathParam("profileId") String profileId) {
		return profileService.deleteMessage(profileId);
	}

}
