package com.suru.testws.messanger.model;

import java.util.Date;

public class Comment {
	private Long id;
	private String comment;
	private Date created;
	private String creator;

	public Comment() {
	}

	public Comment(Long id, String comment, Date created, String creator) {
		super();
		this.id = id;
		this.comment = comment;
		this.created = created;
		this.creator = creator;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

}
