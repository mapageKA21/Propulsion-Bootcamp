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

package util;

import java.util.Scanner;

/**
 * @author Sam Brannen
 */
public class BmiCalculator {

	public static void main(String[] args) throws Exception {

		BmiService bmiService = new BmiService();

		System.out.println("Let's calculate your BMI (kg/m^2)");
		System.out.println();

		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("What is your weight in kilograms?");
			double weight = scanner.nextDouble();
			scanner.nextLine();

			System.out.println("What is your height in meters?");
			double height = scanner.nextDouble();
			scanner.nextLine();

			// double bmi = weight / (height * height);
			double bmi = bmiService.calculate(weight, height);

			// System.out.println("Your BMI is: " + bmi);
			// System.out.println(String.format("Your BMI is: %.2f%n", bmi));
			System.out.format("Your BMI is: %.2f%n", bmi);
		}
	}

}
