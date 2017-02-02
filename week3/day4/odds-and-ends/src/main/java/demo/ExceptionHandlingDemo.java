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

import java.io.IOException;

/**
 * @author Sam Brannen
 */
public class ExceptionHandlingDemo {

	static void throwIOException() throws IOException {
		// look up file name
		// attempt to open file
		// if file does not exist, then...
		throw new IOException("file not found");
	}

	public static void main(String[] args) throws IOException {

		try {
			throwIOException();
		}
		catch (Exception ex) {
			// ex.printStackTrace();
			System.err.println("Error message: " + ex.getMessage());
		}

		System.out.println("*** Made it to the end! ***");
	}

}
