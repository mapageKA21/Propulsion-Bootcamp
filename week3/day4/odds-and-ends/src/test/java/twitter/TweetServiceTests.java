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

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests for the {@link TweetService}.
 *
 * @author Sam Brannen
 */
public class TweetServiceTests {

	private final TweetService tweetService = new TweetService();

	private final Tweet tweet1 = new Tweet("Tweet, tweet!");
	private final Tweet tweet2 = new Tweet("Hello, Twitter!");

	@Before
	public void verifyInitialState() {
		assertNoTweets();
	}

	@Test
	public void saveTweet() {
		tweetService.save(tweet1);
		assertNumTweets(1);
		tweetService.save(tweet2);
		assertNumTweets(2);
	}

	@Test
	public void deleteTweet() {
		tweetService.save(tweet1);
		assertNumTweets(1);
		tweetService.delete(tweet1.getId());
		assertNoTweets();
	}

	@Test
	public void findTweetById() {
		tweetService.save(tweet1);
		assertNumTweets(1);
		Tweet retrievedTweet = tweetService.findById(tweet1.getId());
		assertThat(retrievedTweet).isNotNull();
		assertThat(retrievedTweet).isEqualTo(tweet1);
	}

	@Test
	public void findNonexistentTweetById() {
		Tweet retrievedTweet = tweetService.findById("bogus ID");
		assertThat(retrievedTweet).isNull();
	}

	@Test
	public void findAllTweets() {
		saveTwoTweets();
		List<Tweet> tweets = tweetService.findAll();
		assertThat(tweets).containsExactly(tweet1, tweet2);

		// Uncomment the following to see the results of Tweet#toString()
		// System.out.println(tweets);
	}

	@Test
	public void searchForTweetsContainingTweet() {
		saveTwoTweets();
		List<Tweet> tweets = tweetService.search("Tweet");
		assertThat(tweets).containsExactly(tweet1);
	}

	@Test
	public void searchForTweetsContainingTw() {
		saveTwoTweets();
		List<Tweet> tweets = tweetService.search("Tw");
		assertThat(tweets).containsExactly(tweet1, tweet2);
	}

	@Test
	public void searchForTweetsContainingDog() {
		saveTwoTweets();
		List<Tweet> tweets = tweetService.search("Dog");
		assertThat(tweets).isEmpty();
	}

	private void saveTwoTweets() {
		tweetService.save(tweet1);
		tweetService.save(tweet2);
		assertNumTweets(2);
	}

	private void assertNoTweets() {
		assertNumTweets(0);
	}

	private void assertNumTweets(int expected) {
		assertThat(tweetService.findAll()).hasSize(expected);
	}

}
