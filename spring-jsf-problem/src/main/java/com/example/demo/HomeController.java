package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.RequestScope;

@RequestScope
@Controller
public class HomeController {

	public void actionHello() {
		System.out.println("Hello world!");
	}
}
