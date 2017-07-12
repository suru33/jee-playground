package com.suru.testws.messanger.benas;

import javax.ws.rs.QueryParam;

public class MessageServiceBean {
	private @QueryParam("year") Integer year;
	private @QueryParam("start") Integer start;
	private @QueryParam("size") Integer size;

	public MessageServiceBean() {
	}

	public MessageServiceBean(Integer year, Integer start, Integer size) {
		this.year = year;
		this.start = start;
		this.size = size;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

}
