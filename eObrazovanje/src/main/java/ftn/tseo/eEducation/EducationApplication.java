package ftn.tseo.eEducation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@SpringBootApplication
public class EducationApplication {

	public static void main(String[] args) {
		SpringApplication.run(EducationApplication.class, args);
	}
	
	@Bean
	public SimpleFilterProvider simpleFilter() {
		return new SimpleFilterProvider();
	}
	private static final String path="/error";
	
	@RequestMapping(value=path)
	public String error() {
		return "forward:/index.html";
	}

	public String getErrorPath() {
		return path;
	}
}
