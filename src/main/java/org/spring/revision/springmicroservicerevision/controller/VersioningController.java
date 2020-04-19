package org.spring.revision.springmicroservicerevision.controller;

import org.spring.revision.springmicroservicerevision.bean.Name;
import org.spring.revision.springmicroservicerevision.bean.PersonV1;
import org.spring.revision.springmicroservicerevision.bean.PersonV2;
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningController {
	
	
	@GetMapping("/person/v1")
	public PersonV1 versioOneName() {
		
		return new PersonV1("conroy white");
	}
	
	@GetMapping("/person/v2")
	public PersonV2 versioTwoName() {
		
		return new PersonV2(new Name("conroy"," white"));
	}
	
	@GetMapping(value="/person/param",params="version=1")
	public PersonV1 versioOne2Name() {
		
		return new PersonV1("conroy white");
	}
	
	@GetMapping(value="/person/param",params="version=2")
	public PersonV2 versioTwo2Name() {
		
		return new PersonV2(new Name("conroy"," white"));
	}
	
	@GetMapping(value="/person/header",headers="X-API-VERSION=1")
	public PersonV1 versioOneheaderName() {
		
		return new PersonV1("conroy white");
	}
	
	@GetMapping(value="/person/header",headers="X-API-VERSION=2")
	public PersonV2 versioTwoHeaderName() {
		
		return new PersonV2(new Name("conroy"," white"));
	}
	
	@GetMapping(value="/person/produces",produces="application/vnd.company.app-v1+json")
	public PersonV1 versioOneProducesV1Name() {
		
		return new PersonV1("conroy white");
	}
	
	@GetMapping(value="/person/produces",produces="application/vnd.company.app-v2+xml")
	public PersonV2 versioTwoHProducesName() {
		
		return new PersonV2(new Name("conroy"," white"));
	}

}
