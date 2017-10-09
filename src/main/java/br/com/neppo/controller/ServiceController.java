package br.com.neppo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.neppo.domain.Message;
import br.com.neppo.domain.Response;
import br.com.neppo.service.MessageService;

@RestController
public class ServiceController {

	private static final Logger log = LoggerFactory.getLogger(ServiceController.class);

	@Autowired
	private MessageService messageService;

	@RequestMapping(value = "/message/send.json", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Response> sendMessage(@RequestBody Message message) {
		log.info("incoming message: " + message);
		try {
			Response response = messageService.send(message);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			log.error("Error sending message", e);
			return new ResponseEntity<>(new Response(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@RequestMapping(value = "/message/all.json", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Message>> getAllMessages() {
		try {
			return new ResponseEntity<>(messageService.getAllMessages(), HttpStatus.OK);
		} catch (Exception e) {
			log.error("Error retrieving message", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}