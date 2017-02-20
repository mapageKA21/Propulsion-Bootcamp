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

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Sam Brannen
 */
@Data
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor
public class Tweet {

	private final String id = UUID.randomUUID().toString();

	private LocalDateTime dateCreated = LocalDateTime.now();

	private User author;

	private String text;

	private Tweet replyTo;

	private Tweet retweetOf;

	public Tweet(User author, String text) {
		this.author = author;
		this.text = text;
	}

	public boolean isRetweet() {
		return this.retweetOf != null;
	}

	public boolean isReply() {
		return this.replyTo != null;
	}

	@Override
	public String toString() {
		return "Tweet [id=" + this.id + ", dateCreated=" + this.dateCreated + ", author=" + this.author.getUsername()
				+ ", text=" + this.text + ", replyTo=" + this.replyTo + ", retweetOf=" + this.retweetOf + "]";
	}

}
