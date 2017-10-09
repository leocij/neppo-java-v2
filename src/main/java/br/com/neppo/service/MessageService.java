package br.com.neppo.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import br.com.neppo.domain.Message;
import br.com.neppo.domain.Response;

@Service
public class MessageService {
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(MessageService.class);

	/**
	 * Validate and store this message into the database
	 *
	 * @param message
	 * @return
	 * @throws Exception
	 */
	public Response send(Message message) {
		Response response = new Response();

		// ..... validate message and store

		if (response.getSuccess()) {
			// store the message
		} else {
			// error response
		}
		return response;
	}

	public List<Message> getAllMessages() {
		return new ArrayList<>();
	}

	public Message getById(String id) {
		return null;
	}

}