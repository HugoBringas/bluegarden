package com.bluegarden.entities;

import java.util.Date;

public class Picture {
	public String name;
	public String url;
	public Date dateUploaded;
	public long size;

	public Picture() {

	}

	public Picture(String name, String url, Date dateUploaded, long size) {
		this.name = name;
		this.url = url;
		this.dateUploaded = dateUploaded;
		this.size = size;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Date getDateUploaded() {
		return dateUploaded;
	}

	public void setDateUploaded(Date dateUploaded) {
		this.dateUploaded = dateUploaded;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

}
