package com.pawan.spring.webrestful.filtering;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {

	@GetMapping(path = "/getsomebean")
	public SomeBean getSomeBean() {
		return new SomeBean("bean1","bean2","bean3");
	}
}
