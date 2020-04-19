package org.spring.revision.springmicroservicerevision.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocaleController {

	@Autowired
	MessageSource messageSource;
	
	@GetMapping("/api/locale/message/{word}")
	public String getMessage(@RequestHeader(name="Accept-Language",required=false) Locale locale,@PathVariable String word) {
		return messageSource.getMessage("counting.word", null,locale);
		
	}
	
	
}
