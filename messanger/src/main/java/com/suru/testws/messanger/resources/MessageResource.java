package com.suru.testws.messanger.resources;

import java.net.URI;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.suru.testws.messanger.benas.MessageServiceBean;
import com.suru.testws.messanger.model.Message;
import com.suru.testws.messanger.services.MessageService;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {

	private MessageService messageService = new MessageService();

	public MessageResource() {
	}

	@GET
	public List<Message> getAllMessages(@BeanParam MessageServiceBean bean) {
		if (bean.getYear() != null) {
			return messageService.getMessagesForYear(bean.getYear());
		}
		if (bean.getStart() != null && bean.getSize() != null) {
			return messageService.getPaginatedMessages(bean.getStart(), bean.getSize());
		}
		return messageService.getAllMessages();
	}

	@POST
	public Response addMessage(Message message, @Context UriInfo uriInfo) {
		Message newMessage = messageService.addMessage(message);

		URI uri = uriInfo.getAbsolutePathBuilder().path(newMessage.getId().toString()).build();
		// return Response.status(Status.CREATED)
		// .location(uri)
		// .entity(newMessage)
		// .build();
		//

		return Response.created(uri).entity(newMessage).build();
	}

	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId") Long id) {
		return messageService.getMessage(id);
	}

	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId") Long id, Message message) {
		message.setId(id);
		 return messageService.updateMessage(message);
	}

	@DELETE
	@Path("/{messageId}")
	public Message deleteMessage(@PathParam("messageId") Long id) {
		return messageService.deleteMessage(id);
	}

	@Path("/{messageId}/comments")
	public CommentResource getCommentResource() {
		return new CommentResource();
	}
}
