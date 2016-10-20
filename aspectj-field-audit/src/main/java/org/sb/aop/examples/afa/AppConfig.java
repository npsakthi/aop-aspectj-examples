package org.sb.aop.examples.afa;

import org.sb.aop.examples.afa.audit.FieldAuditAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = AppConfig.class)
public class AppConfig {

	@Bean
	public FieldAuditAspect fieldAuditAspect(){
		return FieldAuditAspect.aspectOf();
	}
	
}
