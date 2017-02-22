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

package service;

import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

/**
 * @author Sam Brannen
 */
@Service
public class MessageService {

	private final MessageFormatter messageFormatter;

	private final JavaMailSender javaMailSender;

	public MessageService(List<MessageFormatter> messageFormatters, JavaMailSender javaMailSender) {
		this.messageFormatter = new CompositeMessageFormatter(messageFormatters);
		this.javaMailSender = javaMailSender;
	}

	public String generateMessage() {
		String message = messageFormatter.format("Hello, World");
		sendNotificationEmail(message);
		return message;
	}

	private void sendNotificationEmail(String message) {
		try {
			MimeMessage mimeMessage = this.javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
			helper.setFrom("system@example.com");
			helper.setTo("test@example.com");
			helper.setSubject("Generated Message");
			helper.setText(message);
			this.javaMailSender.send(mimeMessage);
		}
		catch (MessagingException ex) {
			ex.printStackTrace(System.err);
		}
	}

}
