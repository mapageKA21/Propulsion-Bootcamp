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

package twitter.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static twitter.domain.TestUtils.createJaneDoe;
import static twitter.domain.TestUtils.createJohnSmith;

import java.time.LocalDate;

import org.junit.Test;

/**
 * Unit tests for {@link User} and {@link Tweet}.
 *
 * @author Sam Brannen
 */
public class UserAndTweetTests {

	@Test
	public void userAndTweetRelationships() {
		User user = createJohnSmith();

		assertThat(user.getId()).isNotNull();
		assertThat(user.getDateCreated().toLocalDate()).isEqualTo(LocalDate.now());
		assertThat(user.getTweets()).isEmpty();

		// Uncomment to see results of toString()
		// System.out.println(user);
		assertThat(user.toString()).contains(user.getUsername());

		Tweet tweet = new Tweet(user, "Hello, Twitter!");
		assertThat(tweet.getId()).isNotNull();
		assertThat(tweet.getDateCreated().toLocalDate()).isEqualTo(LocalDate.now());

		user.addTweet(tweet);
		assertThat(user.getTweets()).containsExactly(tweet);

		// Uncomment to see results of toString()
		// System.out.println(tweet);
		assertThat(tweet.toString()).contains(user.getUsername());
		assertThat(tweet.toString()).contains("Hello, Twitter!");
	}

	@Test
	public void replyTo() {
		User john = createJohnSmith();
		Tweet original = new Tweet(john, "Knock, knock!");
		assertThat(original.isReply()).isFalse();

		User jane = createJaneDoe();
		Tweet reply = new Tweet(jane, "Who's there?");
		reply.setReplyTo(original);
		assertThat(reply.isReply()).isTrue();
		assertThat(reply.getReplyTo()).isEqualTo(original);
	}

	@Test
	public void retweet() {
		User john = createJohnSmith();
		Tweet original = new Tweet(john, "Knock, knock!");
		assertThat(original.isRetweet()).isFalse();

		User jane = createJaneDoe();
		Tweet reply = new Tweet(jane, "Who's there?");
		reply.setRetweetOf(original);
		assertThat(reply.isRetweet()).isTrue();
		assertThat(reply.getRetweetOf()).isEqualTo(original);
	}

}
