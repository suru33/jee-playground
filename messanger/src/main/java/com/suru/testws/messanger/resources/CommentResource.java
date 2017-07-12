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

import com.suru.testws.messanger.exception.DataNotFoundException;
import com.suru.testws.messanger.model.Comment;
import com.suru.testws.messanger.services.CommentService;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CommentResource {
	private CommentService commentService = new CommentService();

	public CommentResource() {
	}

	@GET
	public List<Comment> getAllCommentsForMessage(@PathParam("messageId") Long messageId) {
		return commentService.getAllCommentsForMessage(messageId);
	}

	@GET
	@Path("/{commentId}")
	public Comment getComment(@PathParam("messageId") Long messageId, @PathParam("commentId") Long commnetId) {
		Comment comment = commentService.getComment(messageId, commnetId);
		if (comment == null) {
			throw new DataNotFoundException("comment with " + commnetId + " id not found");
		}
		return comment;
	}

	@POST
	public Comment addComment(@PathParam("messageId") Long messageId, Comment comment) {
		return commentService.addComment(messageId, comment);
	}

	@PUT
	@Path("/{commentId}")
	public Comment updateComment(@PathParam("messageId") Long messageId, @PathParam("commentId") Long commentId,
			Comment comment) {
		return commentService.updateComment(messageId, commentId, comment);
	}

	@DELETE
	@Path("/{commentId}")
	public Comment deleteComment(@PathParam("messageId") Long messageId, @PathParam("commentId") Long commentId) {
		return commentService.deleteComment(messageId, commentId);
	}

}
