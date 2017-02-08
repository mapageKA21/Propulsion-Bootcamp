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

/**
 * @author Sam Brannen
 */
public class MessageFormatterFactory {

	// private static final MessageFormatter defaultMessageFormatter = new DefaultMessageFormatter();
	private static final MessageFormatter defaultMessageFormatter = new MessageFormatter() {

		@Override
		public String format(String message) {
			return message + "!";
		}
	};

	private static final MessageFormatter consoleMessageFormatter = new ConsoleMessageFormatter();

	private static final MessageFormatter htmlMessageFormatter = new HtmlMessageFormatter();

	public static MessageFormatter createDefaultFormatter() {
		return defaultMessageFormatter;
	}

	public static MessageFormatter createConsoleFormatter() {
		return consoleMessageFormatter;
	}

	public static MessageFormatter createHtmlFormatter() {
		return htmlMessageFormatter;
	}

	// No longer used since we switched to an anonymous inner class
	@SuppressWarnings("unused")
	private static class DefaultMessageFormatter implements MessageFormatter {

		@Override
		public String format(String message) {
			return message + "!";
		}
	}

}
