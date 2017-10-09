package br.com.neppo.domain;

import java.io.Serializable;

public class Message implements Serializable {

	private static final long serialVersionUID = 1L;
	private String id;
	private String from;
	private String to;
	private String text;

	public Message() {
	}

	public Message(String id, String from, String to, String text) {
		this.id = id;
		this.from = from;
		this.to = to;
		this.text = text;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("Message{");
		sb.append("id='").append(id).append('\'');
		sb.append(", from='").append(from).append('\'');
		sb.append(", to='").append(to).append('\'');
		sb.append(", text='").append(text).append('\'');
		sb.append('}');
		return sb.toString();
	}
}