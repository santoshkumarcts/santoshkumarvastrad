package com.sample.pojo;

import java.util.List;

public class LinkPojo {

	private String key;

	private List<LinkPojo> links = null;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public List<LinkPojo> getLinks() {
		return links;
	}

	public void setLinks(List<LinkPojo> links) {
		this.links = links;
	}
}
