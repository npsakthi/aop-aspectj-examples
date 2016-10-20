package org.sb.aop.examples.afa;

import org.sb.aop.examples.afa.audit.FieldAuditAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AopConfig {

	@Bean
	public FieldAuditAspect fieldAuditAspect(){
		return FieldAuditAspect.aspectOf();
	}
	
}
