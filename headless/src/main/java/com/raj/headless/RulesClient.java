package com.raj.headless;

import org.springframework.stereotype.Component;

@Component
public class RulesClient {
	
	public String getRules() {
		return ">= 1000000, alert !!";
	}

}
