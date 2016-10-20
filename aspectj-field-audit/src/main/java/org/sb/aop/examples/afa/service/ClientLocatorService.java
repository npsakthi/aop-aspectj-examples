package org.sb.aop.examples.afa.service;

import org.springframework.stereotype.Component;

@Component
public class ClientLocatorService {

	public Long getCurrentClientId() {
		return Long.valueOf(12);
	}

}
