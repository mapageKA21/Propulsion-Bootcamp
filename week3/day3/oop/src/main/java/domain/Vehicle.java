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
public class Vehicle {

	private String color;

	private int speed;

	//	public Vehicle() {
	//	}

	public Vehicle(String color, int speed) {
		this.color = color;
		this.speed = speed;
	}

	protected int getDoubleSpeed() {
		return 2 * getSpeed();
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getSpeed() {
		return this.speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	@Override
	public String toString() {
		return "Vehicle [color=" + this.color + ", speed=" + this.speed + "] -- " + super.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.color == null) ? 0 : this.color.hashCode());
		result = prime * result + this.speed;
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
		Vehicle other = (Vehicle) obj;
		if (this.color == null) {
			if (other.color != null)
				return false;
		}
		else if (!this.color.equals(other.color))
			return false;
		if (this.speed != other.speed)
			return false;
		return true;
	}

}
