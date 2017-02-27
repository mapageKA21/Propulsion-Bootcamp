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

package twitter.app;

/**
 * @author Sam Brannen
 */
enum Operation {

	EXIT("Exit"),

	NEW_TWEET("Create new tweet for username"),

	FIND_ALL_TWEETS("Find all tweets"),

	FIND_TWEET("Find tweet by ID"),

	FIND_ALL_USERNAMES("Find all usernames"),

	FIND_TWEETS_BY_USERNAME("Find all tweets by username"),

	FIND_TWEETS_CONTAINING_HASH_TAG("Find all tweets containing hash tag"),

	FIND_TWEETS_MENTIONING_USER("Find all tweets mentioning user");

	private final String displayText;

	private Operation(String displayText) {
		this.displayText = displayText;
	}

	@Override
	public String toString() {
		return String.format("%s: %s", ordinal(), this.displayText);
	}

	static Operation fromOrdinal(int ordinal) {
		for (Operation operation : values()) {
			if (operation.ordinal() == ordinal) {
				return operation;
			}
		}
		return null;
	}

}