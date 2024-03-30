package com.Jayesh.Springboot_sequrity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Jayesh")
public class Controller {

	@GetMapping("/public")
	public String puclicAll() {
		return "hello I am API public....";
	}
	
	@GetMapping("/admin")
	public String adminAll() {
		return "hello I am API admin....";
	}
	
	@GetMapping("/user")
	public String userAll() {
		return "hello I am API user....";
	}
}
