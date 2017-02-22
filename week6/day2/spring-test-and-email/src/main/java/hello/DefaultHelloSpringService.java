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

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

/**
 * @author Sam Brannen
 */
@Service("helloSpringService")
// @Profile("prod")
public class DefaultHelloSpringService implements HelloSpringService {

	private final JavaMailSender javaMailSender;

	private final String message;

	@Autowired
	public DefaultHelloSpringService(JavaMailSender javaMailSender, String message) {
		this.javaMailSender = javaMailSender;
		this.message = message;
	}

	@Override
	public String generateMessage() {
		sendNotificationMail(this.message);
		return this.message;
	}

	private void sendNotificationMail(String message) {
		try {
			MimeMessage mimeMessage = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
			helper.setFrom("system@example.com");
			helper.setTo("test@example.com");
			helper.setSubject("Generated Message");
			helper.setText(message);
			javaMailSender.send(mimeMessage);
		}
		catch (MessagingException ex) {
			ex.printStackTrace(System.err);
		}
	}

}
