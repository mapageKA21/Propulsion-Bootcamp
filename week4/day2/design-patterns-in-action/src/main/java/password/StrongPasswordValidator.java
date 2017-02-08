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

package password;

/**
 * @author Sam Brannen
 */
public class StrongPasswordValidator extends StandardPasswordValidator {

	@Override
	public boolean isValid(String password) {
		// @formatter:off
		return password != null
				&& isLongEnough(password)
				&& containsLetter(password)
				&& containsDigit(password);
		// @formatter:on
	}

	private boolean containsLetter(String password) {
		for (char c : password.toCharArray()) {
			if (Character.isLetter(c)) {
				return true;
			}
		}
		return false;
	}

	private boolean containsDigit(String password) {
		for (char c : password.toCharArray()) {
			if (Character.isDigit(c)) {
				return true;
			}
		}
		return false;
	}

}
