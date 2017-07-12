package com.suru.testws.messanger.services;

import java.util.ArrayList;
import java.util.List;

import com.suru.testws.messanger.db.AppDatabase;
import com.suru.testws.messanger.exception.DataNotFoundException;
import com.suru.testws.messanger.model.Comment;
import com.suru.testws.messanger.model.Message;

public class CommentService {

	private MessageService messageService = new MessageService();
	private AppDatabase database = AppDatabase.getinstance();

	public List<Comment> getAllCommentsForMessage(Long messageId) {

		Message message = messageService.getMessage(messageId);
		if (message == null) {
			throw new DataNotFoundException("message with id: " + messageId + " not found");
		}
		return new ArrayList<Comment>(message.getComments().values());
	}

	public Comment getComment(Long messageId, Long commnetId) {

		Message message = messageService.getMessage(messageId);
		if (message == null) {
			throw new DataNotFoundException("message with id: " + messageId + " not found");
		}
		Comment comment = message.getComments().get(commnetId);
		if (comment == null) {
			throw new DataNotFoundException("comment with id: " + commnetId + " not found");
		}
		return comment;
	}

	public Comment addComment(Long messageId, Comment comment) {
		comment.setId(database.getSeq());
		messageService.getMessage(messageId).getComments().put(comment.getId(), comment);
		return comment;
	}

	public Comment updateComment(Long messageId, Long commentId, Comment comment) {
		comment.setId(commentId);
		messageService.getMessage(messageId).getComments().put(commentId, comment);
		return comment;
	}

	public Comment deleteComment(Long messageId, Long commentId) {
		return messageService.getMessage(messageId).getComments().remove(commentId);
	}
}
