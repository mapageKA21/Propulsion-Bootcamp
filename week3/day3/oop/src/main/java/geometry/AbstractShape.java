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

package geometry;

/**
 * @author Sam Brannen
 */
public abstract class AbstractShape implements Shape {

	@Override
	public final String toString() {
		return String.format("%s[area = %s]", getClass().getSimpleName(), getArea());
	}

	/**
	 * Override {@link Object#hashCode()} and redeclare it as
	 * {@code abstract} in order to force concrete subclasses
	 * to provide a reasonable implementation.
	 */
	@Override
	public abstract int hashCode();

	/**
	 * Override {@link Object#equals(Object)} and redeclare it as
	 * {@code abstract} in order to force concrete subclasses
	 * to provide a reasonable implementation.
	 */
	@Override
	public abstract boolean equals(Object obj);

}
