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
public class RunnableDemo {

	private static class MyRunnable implements Runnable {

		@Override
		public void run() {
			printThreadName();
		}
	}

	public static void main(String[] args) {
		printThreadName();

		Runnable runnable = new MyRunnable();

		new Thread(runnable).start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				printThreadName();
			}
		}).start();

		new Thread(() -> {
			printThreadName();
		}).start();

		new Thread(() -> printThreadName()).start();
	}

	private static void printThreadName() {
		System.out.println("I'm running in thread: " + Thread.currentThread().getName());
	}

}
