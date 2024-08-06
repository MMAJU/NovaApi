package com.spearhead.nova.resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@Controller
public class HomeController {

	@GetMapping("/")
	public String getHome() {
		return "index";
	}


	@GetMapping("/documentations")
	public String getdoc() {
		return "swagger/swagger-ui";
	}
}
