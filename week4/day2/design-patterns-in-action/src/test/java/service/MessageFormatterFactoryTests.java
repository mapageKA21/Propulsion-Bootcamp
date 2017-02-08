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

import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Sam Brannen
 */
public class MessageFormatterFactoryTests {

	@Test
	public void defaultFormatterBehavior() {
		MessageFormatter formatter = MessageFormatterFactory.createDefaultFormatter();
		assertThat(formatter.format("Test")).isEqualTo("Test!");
	}

	@Test
	public void consoleFormatterBehavior() {
		MessageFormatter formatter = MessageFormatterFactory.createConsoleFormatter();
		assertThat(formatter.format("Test")).isEqualTo("Test!");
	}

	@Test
	public void htmlFormatterBehavior() {
		MessageFormatter formatter = MessageFormatterFactory.createHtmlFormatter();
		assertThat(formatter.format("Test")).isEqualTo("<strong>Test</strong>");
	}

	@Ignore("No longer applicable, since we are now using Singletons")
	@Test
	public void factoryMethodsCreateNewInstances() {
		MessageFormatter consoleFormatter1 = MessageFormatterFactory.createConsoleFormatter();
		MessageFormatter consoleFormatter2 = MessageFormatterFactory.createConsoleFormatter();
		assertThat(consoleFormatter1).isNotSameAs(consoleFormatter2);

		MessageFormatter htmlFormatter1 = MessageFormatterFactory.createHtmlFormatter();
		MessageFormatter htmlFormatter2 = MessageFormatterFactory.createHtmlFormatter();
		assertThat(htmlFormatter1).isNotSameAs(htmlFormatter2);
	}

	@Test
	public void factoryMethodsUseSingletons() {
		MessageFormatter defaultFormatter1 = MessageFormatterFactory.createDefaultFormatter();
		MessageFormatter defaultFormatter2 = MessageFormatterFactory.createDefaultFormatter();
		assertThat(defaultFormatter1).isSameAs(defaultFormatter2);

		MessageFormatter consoleFormatter1 = MessageFormatterFactory.createConsoleFormatter();
		MessageFormatter consoleFormatter2 = MessageFormatterFactory.createConsoleFormatter();
		assertThat(consoleFormatter1).isSameAs(consoleFormatter2);

		MessageFormatter htmlFormatter1 = MessageFormatterFactory.createHtmlFormatter();
		MessageFormatter htmlFormatter2 = MessageFormatterFactory.createHtmlFormatter();
		assertThat(htmlFormatter1).isSameAs(htmlFormatter2);
	}

}
