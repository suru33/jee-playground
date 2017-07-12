package com.suru.testws.messanger.model;

public class Profile {
	private Long id;
	private String profileId;
	private String firstName;
	private String lastName;

	public Profile() {
	}

	public Profile(String profileId, String firstName, String lastName) {
		this.profileId = profileId;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProfileId() {
		return profileId;
	}

	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
