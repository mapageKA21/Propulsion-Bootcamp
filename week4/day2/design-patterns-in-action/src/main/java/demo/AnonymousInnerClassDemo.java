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

/**
 * @author Sam Brannen
 */
public class AnonymousInnerClassDemo {

	public static void main(String[] args) {
		System.out.println("Main thread: " + Thread.currentThread().getName());

		Runnable runnable = new Runnable() {

			@Override
			public void run() {
				System.out.println("I'm running in a different thread: " + Thread.currentThread().getName());
			}
		};

		new Thread(runnable).start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("I'm running in a different thread: " + Thread.currentThread().getName());
			}
		}).start();

		// Functional... comes later! ;-)
		new Thread(
			() -> System.out.println("I'm running in a different thread: " + Thread.currentThread().getName())).start();
	}

}
