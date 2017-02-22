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

/**
 * @author Sam Brannen
 */
public class CompositeMessageFormatter implements MessageFormatter {

	private List<MessageFormatter> formatters;

	public CompositeMessageFormatter(List<MessageFormatter> formatters) {
		this.formatters = formatters;
	}

	@Override
	public String format(String message) {
		for (MessageFormatter formatter : this.formatters) {
			message = formatter.format(message);
		}

		return message;
	}

}
