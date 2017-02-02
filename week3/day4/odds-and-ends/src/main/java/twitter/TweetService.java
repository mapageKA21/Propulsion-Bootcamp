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

package twitter;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Sam Brannen
 */
public class TweetService {

	private final Map<String, Tweet> database = new LinkedHashMap<>();

	/**
	 * Save new {@link Tweet}.
	 */
	public void save(Tweet tweet) {
		this.database.put(tweet.getId(), tweet);
	}

	/**
	 * Delete {@link Tweet} with supplied ID.
	 */
	public void delete(String id) {
		this.database.remove(id);
	}

	/**
	 * Find {@link Tweet} with supplied ID; returns {@code null} if not found.
	 */
	public Tweet findById(String id) {
		return this.database.get(id);
	}

	/**
	 * Find all tweets.
	 */
	public List<Tweet> findAll() {
		return new ArrayList<>(this.database.values());
	}

	/**
	 * Search for all tweets that contain the supplied text.
	 */
	public List<Tweet> search(String text) {

		// Pre Java 8 way to do it manually.
		//
		//List<Tweet> tweets = new ArrayList<>();
		//
		//for (Tweet tweet : findAll()) {
		//	if (tweet.getText().contains(text)) {
		//		tweets.add(tweet);
		//	}
		//}
		//
		//return tweets;

		// Java 8 way to do it with streams and lambda expressions.
		//
		// @formatter:off
		return findAll().stream()
				.filter(tweet -> tweet.getText().contains(text))
				.collect(toList());
		// @formatter:on
	}

}
