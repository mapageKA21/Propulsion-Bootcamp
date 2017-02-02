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

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author Sam Brannen
 */
public class Tweet {

	/**
	 * Unique ID for this {@code Tweet}.
	 */
	private final String id = UUID.randomUUID().toString();

	/**
	 * Timestamp when this {@code Tweet} was created.
	 */
	private final LocalDateTime timestamp = LocalDateTime.now();

	/**
	 * Text of this {@code Tweet}.
	 */
	private final String text;

	public Tweet(String text) {
		this.text = text;
	}

	public String getId() {
		return this.id;
	}

	public LocalDateTime getTimestamp() {
		return this.timestamp;
	}

	public String getText() {
		return this.text;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tweet other = (Tweet) obj;
		if (this.id == null) {
			if (other.id != null)
				return false;
		}
		else if (!this.id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Tweet [id=" + this.id + ", timestamp=" + this.timestamp + ", text=" + this.text + "]";
	}

}
