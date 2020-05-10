package com.naresh.controller;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.naresh.service.EmailServiceImpl;

@RestController
@RequestMapping("/email")
public class EmailController {

	private static final Logger LOG = LoggerFactory.getLogger(EmailController.class);
	@Autowired
	EmailServiceImpl emailService;

	@GetMapping(value = "/simple-email/{user-email}")
	public @ResponseBody ResponseEntity<String> sendSimpleEmail(@PathVariable("user-email") String email) {
		
		

		try {
			emailService.sendSimpleEmail(email, "APSPDCL", "Use This Password To Change Your Password!!"+new Random().nextInt(10000));
		} catch (MailException mailException) {
			LOG.error("Error while sending out email..{}", mailException.fillInStackTrace());
			return new ResponseEntity<>("Unable to send email", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>("Please check your inbox", HttpStatus.OK);
	}

}
