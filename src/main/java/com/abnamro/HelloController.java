package com.abnamro;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@Value("${server.name}")
	private String serverName;

	@RequestMapping(method = RequestMethod.GET, value = "/hello")
	public String hello() {
		return "hello, you!! I am " + serverName;
	}

	@Secured("ROLE_ABN")
	@RequestMapping("/helloA")
	public String helloA() {
		return "hello, Admin" + serverName;
	}

}
