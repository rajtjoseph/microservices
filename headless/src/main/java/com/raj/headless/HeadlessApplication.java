package com.raj.headless;

import org.springframework.stereotype.Component;

@Component
public class HeadlessApplication {

	public String fireRules(String ruleName) {
		return ruleName + " started abd ran successfully !";
	}

}
