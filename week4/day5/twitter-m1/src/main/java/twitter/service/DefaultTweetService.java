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

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import twitter.domain.Tweet;
import twitter.repository.TweetRepository;

/**
 * Default implementation of the {@link TweetService} API.
 *
 * @author Sam Brannen
 */
public class DefaultTweetService implements TweetService {

	private static final Logger logger = LogManager.getLogger(DefaultTweetService.class);

	private final TweetRepository repository;

	public DefaultTweetService(TweetRepository repository) {
		this.repository = repository;
	}

	@Override
	public void save(Tweet tweet) {
		logger.debug(() -> "Saving tweet: " + tweet);
		this.repository.save(tweet, tweet.getId());
	}

	@Override
	public void deleteTweet(String tweetId) {
		logger.debug(() -> "Deleting tweet with ID: " + tweetId);
		this.repository.deleteById(tweetId);
	}

	@Override
	public Tweet findTweet(String tweetId) {
		logger.debug(() -> "Finding tweet with ID: " + tweetId);
		return this.repository.findById(tweetId);
	}

	@Override
	public List<Tweet> findAllTweets() {
		logger.debug("Finding all tweets");
		return this.repository.findAll();
	}

	@Override
	public List<Tweet> findAllTweetsByUserId(String userId) {
		logger.debug(() -> "Finding all tweets for user with ID: " + userId);
		// @formatter:off
		return findAllTweets().stream()
				.filter(t -> t.getAuthor().getId().equals(userId))
				.collect(toList());
		// @formatter:on
	}

	@Override
	public List<Tweet> findAllTweetsByUsername(String username) {
		logger.debug(() -> "Finding all tweets for @" + username);
		// @formatter:off
		return findAllTweets().stream()
				.filter(t -> t.getAuthor().getUsername().equals(username))
				.collect(toList());
		// @formatter:on
	}

}
