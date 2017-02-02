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
public abstract class AbstractMessageService implements MessageService {

	/**
	 * Follows the Template Method design pattern.
	 *
	 * https://en.wikipedia.org/wiki/Template_method_pattern
	 *
	 * <p>Cannot be overridden by subclasses.
	 */
	@Override
	public final String generateMessage() {
		return String.format(getTemplate(), getHelloText(), getWorldText());
	}

	/**
	 * Returns the default template with placeholders for
	 * {@link #getHelloText()} and {@link #getWorldText()}.
	 *
	 * <p>Can be overridden by subclasses.
	 */
	protected String getTemplate() {
		return "%s, %s!";
	}

	/**
	 * Returns the word "Hello" in a specific language.
	 */
	protected abstract String getHelloText();

	/**
	 * Returns the word "World" in a specific language.
	 */
	protected abstract String getWorldText();

}
