package com.example.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AvailController {
	
//	@Autowired
//	private KafkaTemplate<Object, Object> template;
	@Autowired
	private KafkaTemplate<Object,Object> template;
	@RequestMapping("/")
	public String index() {
		this.template.executeInTransaction(t -> t.send("mcglobal-customers","Yes I am Available"));
		return "Yes I am available";
	}

}
