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

package twitter.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static twitter.domain.TestUtils.createJaneDoe;
import static twitter.domain.TestUtils.createJohnSmith;

import org.junit.Test;

import twitter.domain.Tweet;

/**
 * @author Sam Brannen
 */
public class TweetRepositoryTests {

	private final TweetRepository repository = new InMemoryTweetRepository();

	@Test
	public void save() {
		// Given
		assertThat(repository.findAll()).isEmpty();

		// When
		Tweet tweet = new Tweet(createJohnSmith(), "test");
		repository.save(tweet, tweet.getId());

		// Then
		assertThat(repository.findAll()).containsExactly(tweet);
	}

	@Test
	public void findById() {
		// Given
		Tweet tweet = new Tweet(createJohnSmith(), "test");
		assertThat(repository.findById(tweet.getId())).isNull();

		// When
		repository.save(tweet, tweet.getId());

		// Then
		assertThat(repository.findById(tweet.getId())).isEqualTo(tweet);
	}

	@Test
	public void findAll() {
		// Given
		Tweet tweet1 = new Tweet(createJohnSmith(), "test");
		Tweet tweet2 = new Tweet(createJaneDoe(), "test");

		// When
		repository.save(tweet1, tweet1.getId());
		repository.save(tweet2, tweet2.getId());

		// Then
		assertThat(repository.findAll()).containsExactlyInAnyOrder(tweet1, tweet2);
	}

	@Test
	public void deleteById() {
		// Given
		Tweet tweet = new Tweet(createJohnSmith(), "test");
		repository.save(tweet, tweet.getId());
		assertThat(repository.findAll().size()).isEqualTo(1);

		// When
		repository.deleteById(tweet.getId());

		// Then
		assertThat(repository.findAll()).isEmpty();
	}

	@Test
	public void deleteAll() {
		// Given
		Tweet tweet1 = new Tweet(createJohnSmith(), "test");
		Tweet tweet2 = new Tweet(createJaneDoe(), "test");
		repository.save(tweet1, tweet1.getId());
		repository.save(tweet2, tweet2.getId());
		assertThat(repository.findAll().size()).isEqualTo(2);

		// When
		repository.deleteAll();

		// Then
		assertThat(repository.findAll()).isEmpty();
	}

}
