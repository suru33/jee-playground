package com.suru.testws.messanger.db;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.suru.testws.messanger.model.Comment;
import com.suru.testws.messanger.model.Message;
import com.suru.testws.messanger.model.Profile;

public class AppDatabase {
	private static final AppDatabase APP_DATABASE = new AppDatabase();

	private AppDatabase() {

		messages = new HashMap<>();
		profiles = new HashMap<>();
		dbSeq = 0L;

		profiles.put("suru", new Profile("suru", "V", "Polam"));
		profiles.put("jak", new Profile("jak", "Jack", "Sam"));
		profiles.put("stuart", new Profile("stuart", "Stuart", "Poland"));
		profiles.put("jason005", new Profile("jason005", "Jason", "Bourn"));
		profiles.put("proh", new Profile("proh", "Pete", "Hola"));

		Message m1 = new Message(getSeq(), "Message-1", "suru", new Date());
		Comment m1c1 = new Comment(getSeq(), "m1-c1", new Date(), "suru");
		Comment m1c2 = new Comment(getSeq(), "m1-c2", new Date(), "jak");
		Comment m1c3 = new Comment(getSeq(), "m1-c3", new Date(), "proh");
		Comment m1c4 = new Comment(getSeq(), "m1-c4", new Date(), "suru");
		m1.getComments().put(m1c1.getId(), m1c1);
		m1.getComments().put(m1c2.getId(), m1c2);
		m1.getComments().put(m1c3.getId(), m1c3);
		m1.getComments().put(m1c4.getId(), m1c4);

		Message m2 = new Message(getSeq(), "Message-2", "jak", new Date());
		Comment m2c1 = new Comment(getSeq(), "m2-c1", new Date(), "suru");
		Comment m2c2 = new Comment(getSeq(), "m2-c2", new Date(), "jak");
		Comment m2c3 = new Comment(getSeq(), "m2-c3", new Date(), "jak");
		Comment m2c4 = new Comment(getSeq(), "m2-c4", new Date(), "suru");
		m2.getComments().put(m2c1.getId(), m2c1);
		m2.getComments().put(m2c2.getId(), m2c2);
		m2.getComments().put(m2c3.getId(), m2c3);
		m2.getComments().put(m2c4.getId(), m2c4);

		Message m3 = new Message(getSeq(), "Message-3", "proh", new Date());
		Comment m3c1 = new Comment(getSeq(), "m3-c1", new Date(), "proh");
		Comment m3c2 = new Comment(getSeq(), "m3-c2", new Date(), "jak");
		Comment m3c3 = new Comment(getSeq(), "m3-c3", new Date(), "stuart");
		Comment m3c4 = new Comment(getSeq(), "m3-c4", new Date(), "suru");
		m3.getComments().put(m3c1.getId(), m3c1);
		m3.getComments().put(m3c2.getId(), m3c2);
		m3.getComments().put(m3c3.getId(), m3c3);
		m3.getComments().put(m3c4.getId(), m3c4);

		messages.put(m1.getId(), m1);
		messages.put(m2.getId(), m2);
		messages.put(m3.getId(), m3);
	}

	public static AppDatabase getinstance() {
		return APP_DATABASE;
	}

	private Map<Long, Message> messages;
	private final Map<String, Profile> profiles;
	private Long dbSeq;

	public Map<Long, Message> getMessages() {
		return messages;
	}

	public Map<String, Profile> getProfiles() {
		return profiles;
	}

	public Long getSeq() {
		dbSeq++;
		return dbSeq;
	}

}
