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

import java.util.Arrays;
import java.util.List;

/**
 * @author Sam Brannen
 */
class CompositeDemo {

	public static void main(String[] args) {

		//		List<MessageFormatter> formatters = new ArrayList<>();
		//
		//		formatters.add(new TrimmingMessageFormatter());
		//		formatters.add(new UpperCaseMessageFormatter());
		//		formatters.add(new HtmlMessageFormatter());
		//
		//		MessageFormatter compositeFormatter = new CompositeMessageFormatter(formatters);

		List<MessageFormatter> formatters = Arrays.asList(new TrimmingMessageFormatter(),
			new UpperCaseMessageFormatter(), new HtmlMessageFormatter());

		MessageFormatter compositeFormatter = new CompositeMessageFormatter(formatters);

		// Prints: <strong>TEST</strong>
		System.out.println(compositeFormatter.format("   Test  "));
	}

}
