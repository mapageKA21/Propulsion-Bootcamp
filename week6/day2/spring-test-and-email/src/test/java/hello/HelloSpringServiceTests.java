/*
 * Copyright 2016-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package hello;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertSame;

import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.subethamail.wiser.Wiser;

import config.HelloSpringConfig;
import config.TestMailConfig;

/**
 * @author Sam Brannen
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { HelloSpringConfig.class, TestMailConfig.class })
@ActiveProfiles("dev")
// @ActiveProfiles({ "dev", "prod" })
public class HelloSpringServiceTests {

	@Autowired
	ApplicationContext context;

	@Autowired
	HelloSpringService service;

	@Autowired
	Wiser wiser;

	@Autowired
	int smtpPort;

	@Test
	public void testHelloSpringService() throws Exception {
		assertThat(wiser.getMessages()).hasSize(0);

		//System.out.println(smtpPort);
		assertSame(service, context.getBean(HelloSpringService.class));
		final String expected = "Hello, Test!";
		assertThat(service.generateMessage()).isEqualTo(expected);

		assertThat(wiser.getMessages()).hasSize(1);

		MimeMessage mimeMessage = wiser.getMessages().get(0).getMimeMessage();
		String from = mimeMessage.getFrom()[0].toString();
		String to = mimeMessage.getRecipients(RecipientType.TO)[0].toString();
		String subject = mimeMessage.getSubject();
		String body = mimeMessage.getContent().toString().trim();

		// assert expected values...
		assertThat(from).isEqualTo("system@example.com");
		assertThat(to).isEqualTo("test@example.com");
		assertThat(subject).isEqualTo("Generated Message");
		assertThat(body).isEqualTo(expected);

		// good idea to clear sent messages
		wiser.getMessages().clear();
	}

}
