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

import domain.Vehicle;

/**
 * @author Sam Brannen
 */
public class VehicleDemo {

	public static void main(String[] args) {
		Vehicle vehicle1 = new Vehicle("Honda");
		vehicle1.setColor("red");

		Vehicle vehicle2 = new Vehicle("Honda");
		vehicle2.setColor("red");

		// System.out.println(vehicle1.getColor());
		System.out.println("Vehicle: " + vehicle1);

		System.out.println("Equal? " + vehicle1.equals(vehicle2));
	}

}
