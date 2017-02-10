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

package demo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Sam Brannen
 */
public class StreamOfDemo {

	public static void main(String[] args) {

		banner("Stream.of - String");
		// Stream<String> strings = Stream.of("A", "B", "C");
		Stream.of("A", "B", "C").forEach(System.out::println);
		System.out.println("Size of string stream: " + Stream.of("A", "B", "C").count());

		banner("Stream.of - Integer");
		// Stream<Integer> numbers = Stream.of(1, 2, 3, 4);
		Stream.of(1, 2, 3, 4).forEach(System.out::println);
		System.out.println("Size of number stream: " + Stream.of(1, 2, 3, 4).count());

		banner("IntStream.of");
		// IntStream vs. Stream<Integer>
		IntStream.of(1, 2, 3, 4).forEach(System.out::println);
		System.out.println("Size of IntStream: " + IntStream.of(1, 2, 3, 4).count());

		banner("skip(), limit(), and peek() with IntStream");
		// @formatter:off
		IntStream.of(1, 2, 3, 4)
			.peek(System.out::println)
			.skip(1)
			.limit(2)
			.forEach(System.out::println);
		// @formatter:on

		banner("Parallel Stream");
		List<String> stringList = Arrays.asList("foo", "bar", "baz");
		stringList.parallelStream().forEach(System.out::println);
	}

	private static void banner(String header) {
		System.out.println();
		System.out.println("=================================================");
		System.out.println("=== " + header);
		System.out.println("=================================================");
	}

}
