package com.suru.testws.messanger.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.suru.testws.messanger.db.AppDatabase;
import com.suru.testws.messanger.exception.DataNotFoundException;
import com.suru.testws.messanger.model.Message;

public class MessageService {
	private Map<Long, Message> messages;

	public MessageService() {
		this.messages = AppDatabase.getinstance().getMessages();
	}

	public Message addMessage(Message message) {
		message.setId(AppDatabase.getinstance().getSeq());
		message.setCreated(new Date());
		messages.put(message.getId(), message);
		return message;
	}

	public Message updateMessage(Message message) {
		if (message.getId() <= 0) {
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}

	public List<Message> getAllMessages() {
		return new ArrayList<>(messages.values());
	}

	public Message getMessage(Long id) {
		Message message = messages.get(id);
		if (message == null) {
			throw new DataNotFoundException("message with id: " + id + " not found");
		}
		return messages.get(id);
	}

	public Message deleteMessage(Long id) {
		return messages.remove(id);
	}

	public List<Message> getMessagesForYear(int year) {
		List<Message> messagesForYear = new ArrayList<>();
		Calendar calendar = Calendar.getInstance();
		for (Message m : messages.values()) {
			calendar.setTime(m.getCreated());
			if (calendar.get(Calendar.YEAR) == year) {
				messagesForYear.add(m);
			}
		}
		return messagesForYear;
	}

	public List<Message> getPaginatedMessages(int start, int size) {
		start--;
		if (start + size > messages.size()) {
			return new ArrayList<>();
		}
		ArrayList<Message> list = new ArrayList<>(messages.values());
		return list.subList(start, start + size);
	}
}
