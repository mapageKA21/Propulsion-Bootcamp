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

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import config.HelloSpringConfig;
import config.MessageServiceConfig;

/**
 * @author Sam Brannen
 */

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = MessageServiceConfig.class)
public class MessageServiceTests {

	@Test
	public void consoleFormatter() {
		MessageFormatter formatter = new ConsoleMessageFormatter();

		MessageService service = new MessageService(formatter);

		assertThat(service.generateMessage()).isEqualTo("Hello, World!");
	}

	@Test
	public void markdownFormatter() {
		MessageFormatter formatter = new MarkdownMessageFormatter();

		MessageService service = new MessageService(formatter);

		assertThat(service.generateMessage()).isEqualTo("**Hello, World**");
	}

	@Test
	public void compositeFormatter() {

		// Before Spring:
		// MessageFormatter formatter = new CompositeMessageFormatter(formatters);
		// MessageService service = new MessageService(formatter);

		@SuppressWarnings("resource")
		ApplicationContext context = //
			new AnnotationConfigApplicationContext(MessageServiceConfig.class);

		MessageService service = context.getBean(MessageService.class);

		assertThat(service.generateMessage()).isEqualTo("<strong>HELLO, WORLD</strong>");
	}

}
