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

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import twitter.config.TwitterAppConfig;
import twitter.domain.Tweet;
import twitter.service.TweetService;
import twitter.service.UserService;

/**
 * Command-line application that serves as a text-based
 * user interface for the Twitter application.
 *
 * @author Sam Brannen
 */
public class TwitterApp {

	private static final Scanner scanner = new Scanner(System.in);

	private static UserService userService;
	private static TweetService tweetService;

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(TwitterAppConfig.class);

		userService = context.getBean(UserService.class);
		tweetService = context.getBean(TweetService.class);

		while (true) {
			Operation operation = getOperationFromUser();

			switch (operation) {
				case EXIT: {
					banner("Exiting... 👋");
					System.exit(0);
				}
				case NEW_TWEET: {
					createNewTweet();
					break;
				}
				case FIND_ALL_TWEETS: {
					findAllTweets();
					break;
				}
				case FIND_TWEET: {
					findTweetById();
					break;
				}
				case FIND_ALL_USERNAMES: {
					findAllUsernames();
					break;
				}
				case FIND_TWEETS_BY_USERNAME: {
					findAllTweetsByUsername();
					break;
				}
				case FIND_TWEETS_CONTAINING_HASH_TAG: {
					findAllTweetsContainingHashTag();
					break;
				}
				case FIND_TWEETS_MENTIONING_USER: {
					findAllTweetsMentioningUser();
					break;
				}
				default:
					System.err.printf("Unsupported operation: %s%n%n", operation.ordinal());
					break;
			}
		}
	}

	// =========================================================================

	private static void printTweet(Tweet tweet) {
		System.out.printf("ID: %s >> @%s tweeted: %s%n", tweet.getId(), tweet.getAuthor(), tweet.getText());
	}

	private static void createNewTweet() {
		banner("New Tweet");

		String author = promptForString("Username");
		String text = promptForString("Tweet");

		Tweet tweet = new Tweet(author, text);
		tweetService.save(tweet);
	}

	private static void findAllTweets() {
		banner("Tweets");

		List<Tweet> tweets = tweetService.findAll();
		if (tweets.isEmpty()) {
			System.out.println("No Tweets!");
		}
		else {
			tweets.forEach(TwitterApp::printTweet);
		}
	}

	private static void findTweetById() {
		banner("Find Tweet");

		prompt("Tweet ID");
		Integer id = scanner.nextInt();
		scanner.nextLine();

		System.out.println();
		Tweet tweet = tweetService.findById(id);
		if (tweet == null) {
			System.err.println("Could not find tweet with ID: " + id);
		}
		else {
			printTweet(tweet);
		}
	}

	private static void findAllUsernames() {
		banner("Usernames");

		List<String> users = userService.findAllUsernames();
		if (users.isEmpty()) {
			System.out.println("No Tweeters!");
		}
		else {
			users.forEach(System.out::println);
		}
	}

	private static void findAllTweetsByUsername() {
		banner("Tweets by user");

		String username = promptForString("Username");

		List<Tweet> tweets = tweetService.findAllByUsername(username);
		if (tweets.isEmpty()) {
			System.out.println("No tweets for @" + username);
		}
		else {
			tweets.forEach(TwitterApp::printTweet);
		}
	}

	private static void findAllTweetsContainingHashTag() {
		banner("Tweets containing hash tag");

		String hashTag = promptForString("Hash tag");
		if (hashTag.startsWith("#")) {
			hashTag = hashTag.substring(1);
		}

		List<Tweet> tweets = tweetService.findAllContainingHashTag(hashTag);
		if (tweets.isEmpty()) {
			System.out.println("No tweets containing hash tag: #" + hashTag);
		}
		else {
			tweets.forEach(TwitterApp::printTweet);
		}
	}

	private static void findAllTweetsMentioningUser() {
		banner("Tweets mentioning user");

		String username = promptForString("Username");
		if (username.startsWith("@")) {
			username = username.substring(1);
		}

		List<Tweet> tweets = tweetService.findAllMentioningUsername(username);
		if (tweets.isEmpty()) {
			System.out.println("No tweets mentioning user: @" + username);
		}
		else {
			tweets.forEach(TwitterApp::printTweet);
		}
	}

	// =========================================================================

	private static Operation getOperationFromUser() {
		banner("Menu");

		while (true) {
			System.out.println();
			for (Operation current : Operation.values()) {
				System.out.println(current);
			}

			prompt("Operation");
			if (scanner.hasNextInt()) {
				int input = scanner.nextInt();
				scanner.nextLine();
				Operation operation = Operation.fromOrdinal(input);
				if (operation == null) {
					System.err.println("Invalid operation: " + input);
				}
				else {
					return operation;
				}
			}
			else {
				if (scanner.hasNextLine()) {
					System.err.println("Invalid operation: " + scanner.nextLine());
				}
			}
		}
	}

	private static void prompt(String label) {
		System.out.printf("%nEnter %s: ", label);
	}

	private static String promptForString(String label) {
		prompt(label);
		return scanner.nextLine();
	}

	private static void banner(String header) {
		System.out.println();
		System.out.println("=================================================");
		System.out.println("=== " + header);
		System.out.println("=================================================");
	}

}
