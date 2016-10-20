package org.sb.aop.examples.afa.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.sb.aop.examples.afa.AppConfig;
import org.sb.aop.examples.afa.domain.Client;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
public class AppTest {

	@Test
	public void aopAuditTest() {
		Client client = new Client();
		client.setId(1L);
		client.setEmail("client@somemail.org");
		client.setLastName("Jon");
		client.setFirstName("Snow");
		client.setMobileNumber("+7(123)456-78-91");
	}

}
