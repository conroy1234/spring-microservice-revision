package org.spring.revision.springmicroservicerevision.config;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.collect.Ordering;

import springfox.documentation.service.ApiDescription;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwiggerConfig {

	public static final Contact DEFAULT_CONTACT = new MyContent("Conroy White", "conroy.white@someemail.com", "conroy@someemail.com","custom swager api",LocalDate.now());
	public static final ApiInfo DEFAULT_API_INFO = new ApiInfo("Learning spring microservices", "microservices complete application", "1.0", "urn:tos",
			DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0");

	static List<String> list = Arrays.asList("application/json","application/xml");
	private static final Set<String> DEFAULT_PRODUCE_AND_CONSUME =new HashSet<String>(list);

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAULT_API_INFO)
				.produces(DEFAULT_PRODUCE_AND_CONSUME)
				.consumes(DEFAULT_PRODUCE_AND_CONSUME);

	}

}
