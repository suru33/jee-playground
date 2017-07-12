package com.suru.testws.messanger.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.suru.testws.messanger.db.AppDatabase;
import com.suru.testws.messanger.exception.DataNotFoundException;
import com.suru.testws.messanger.model.Profile;

public class ProfileService {
	private Map<String, Profile> profiles;

	public ProfileService() {
		this.profiles = AppDatabase.getinstance().getProfiles();
	}

	public Profile addProfile(Profile profile) {
		profile.setId(AppDatabase.getinstance().getSeq());
		profiles.put(profile.getProfileId(), profile);
		return profile;
	}

	public Profile updateProfile(Profile profile) {
		if (profile.getProfileId().isEmpty()) {
			return null;
		}
		profiles.put(profile.getProfileId(), profile);
		return profile;
	}

	public List<Profile> getAllProfiles() {
		return new ArrayList<>(profiles.values());
	}

	public Profile getProfile(String profileId) {
		Profile profile = profiles.get(profileId);
		if (profile == null) {
			throw new DataNotFoundException("profile with id: " + profileId + " not found");
		}
		return profile;
	}

	public Profile deleteMessage(String profileId) {
		return profiles.remove(profileId);
	}
}
