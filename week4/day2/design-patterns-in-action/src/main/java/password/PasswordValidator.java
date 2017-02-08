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
public interface PasswordValidator {

	/**
	 * Determines if the supplied password is long enough.
	*/
	boolean isLongEnough(String password);

	/**
	 * Determines if the supplied password is valid.
	 *
	 * <p>Delegates to {@link #isLongEnough(String)} by default.
	 */
	default boolean isValid(String password) {
		return password != null && isLongEnough(password);
	}

}
