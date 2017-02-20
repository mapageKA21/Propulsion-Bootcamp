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

package twitter.service;

import static org.assertj.core.api.Assertions.assertThat;
import static twitter.domain.TestUtils.createJaneDoe;
import static twitter.domain.TestUtils.createJohnSmith;

import org.junit.Test;

import twitter.domain.Tweet;
import twitter.domain.User;
import twitter.repository.InMemoryTweetRepository;
import twitter.repository.TweetRepository;

/**
 * Unit tests for the {@link DefaultTweetService}.
 *
 * @author Sam Brannen
 */
public class TweetServiceTests {

	// Could use Mockito to mock the repository, but our current is an
	// in-memory "fake". So it's not such a bad idea to just use the
	// in-memory implementation directly.
	private final TweetRepository repository = new InMemoryTweetRepository();

	private final TweetService service = new DefaultTweetService(repository);

	@Test
	public void findAllTweetsByUserId() {
		// Given
		User john = createJohnSmith();
		User jane = createJaneDoe();
		Tweet tweet1 = new Tweet(john, "test");
		Tweet tweet2 = new Tweet(john, "test");
		Tweet tweet3 = new Tweet(jane, "test");

		// When
		repository.save(tweet1, tweet1.getId());
		repository.save(tweet2, tweet2.getId());
		repository.save(tweet3, tweet3.getId());

		// Then
		assertThat(service.findAllTweetsByUserId(john.getId())).containsExactlyInAnyOrder(tweet1, tweet2);
	}

	@Test
	public void findAllTweetsByUsername() {
		// Given
		User john = createJohnSmith();
		User jane = createJaneDoe();
		Tweet tweet1 = new Tweet(john, "test");
		Tweet tweet2 = new Tweet(john, "test");
		Tweet tweet3 = new Tweet(jane, "test");

		// When
		repository.save(tweet1, tweet1.getId());
		repository.save(tweet2, tweet2.getId());
		repository.save(tweet3, tweet3.getId());

		// Then
		assertThat(service.findAllTweetsByUsername(john.getUsername())).containsExactlyInAnyOrder(tweet1, tweet2);
	}

	// Omitting tests for save(), deleteTweet(), findTweet(), and findAllTweets(),
	// since they currently only delegate to the repository.

}
