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

package domain;

/**
 * @author Sam Brannen
 */
public class Pet implements Animal {

	private final String name;

	private final String says;

	public Pet(String name, String says) {
		this.name = name;
		this.says = says;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String speak() {
		return this.says;
	}

	@Override
	public String toString() {
		return "Pet [name=" + this.name + ", says=" + this.says + "]";
	}

}
