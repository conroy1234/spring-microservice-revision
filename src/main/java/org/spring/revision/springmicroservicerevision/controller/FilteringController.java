package org.spring.revision.springmicroservicerevision.controller;

import org.spring.revision.springmicroservicerevision.bean.SomeJsonIgnoreBean;
import org.spring.revision.springmicroservicerevision.bean.SomeJsonIgnoreBeanBinamic;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {

	@GetMapping("/some/jsonIgnoreBean")
	public SomeJsonIgnoreBean someBean() {
		
		
		return new SomeJsonIgnoreBean("value1","value2","value3");
	}
	
	@GetMapping("/some/jsonIgnoreBean-dinamic")
	public ObjectMapper someBeanDinamic() {
		

		SimpleFilterProvider filterProvider = new SimpleFilterProvider();		
		filterProvider.addFilter("PersonAddressFilter", SimpleBeanPropertyFilter.filterOutAllExcept("value1"));
		
		
		SomeJsonIgnoreBeanBinamic someJsonIgnoreBeanBinamic =	new SomeJsonIgnoreBeanBinamic("value1","value2","value3");
		MappingJacksonValue mapping = new MappingJacksonValue(someJsonIgnoreBeanBinamic);
		ObjectMapper om = new ObjectMapper();
		om.setFilterProvider(filterProvider);
		mapping.setFilters(filterProvider);
		
		return om;
	}
}
