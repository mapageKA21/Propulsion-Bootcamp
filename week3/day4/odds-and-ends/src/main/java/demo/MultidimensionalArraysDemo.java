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

/**
 * @author Sam Brannen
 */
public class MultidimensionalArraysDemo {

	public static void main(String[] args) {
		multiplicationTable();
		coordinatesGrid();
	}

	private static void multiplicationTable() {
		int[][] table = new int[10][10];

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				table[i][j] = (i + 1) * (j + 1);
			}
		}

		printBanner("Multiplication Table");
		print2dArray(table);
	}

	private static void coordinatesGrid() {
		String[][] grid = new String[3][3];

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				grid[i][j] = String.format("(%d,%d)", (i + 1), (j + 1));
			}
		}

		printBanner("Coordinates Grid");
		print2dArray(grid);
	}

	private static void printBanner(String header) {
		System.out.println("=========================================");
		System.out.println("=== " + header);
		System.out.println("=========================================");
	}

	private static void print2dArray(Object[][] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(Arrays.toString(array[i]));
		}
	}

	private static void print2dArray(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(Arrays.toString(array[i]));
		}
	}

}
