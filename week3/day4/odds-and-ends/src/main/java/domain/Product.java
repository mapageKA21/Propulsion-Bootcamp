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

import enums.Color;
import enums.Size;

/**
 * @author Sam Brannen
 */
public class Product {

	private final String name;
	private Color color;
	private Size size;
	private double price;

	public Product(String name, Color color, Size size, double price) {
		this.name = name;
		this.color = color;
		this.size = size;
		this.price = price;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getName() {
		return this.name;
	}

	public Color getColor() {
		return this.color;
	}

	public Size getSize() {
		return this.size;
	}

	public double getPrice() {
		return this.price;
	}

	@Override
	public String toString() {
		return "Product [name=" + this.name + ", color=" + this.color + ", size=" + this.size + ", price=" + this.price
				+ "]";
	}

}
