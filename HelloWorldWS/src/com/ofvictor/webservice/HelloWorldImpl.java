package com.ofvictor.webservice;

import javax.jws.WebService;

@WebService(endpointInterface = "com.ofvictor.webservice.HelloWorld")
public class HelloWorldImpl implements HelloWorld {

	public String helloWorld(String name) {
		return "Hello world from " + name;
	}
}