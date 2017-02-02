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

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

/**
 * Unit tests for shapes.
 *
 * @author Sam Brannen
 */
public class ShapeTests {

	@Test
	public void circle() {
		Circle circle = new Circle(2.5);
		// assertEquals("area of circle", 19.63, circle.getArea(), 0.01);
		assertThat(circle.getArea()).isEqualTo(19.63, offset(0.01));
	}

	@Test
	public void triangle() {
		Triangle triangle = new Triangle(2.5, 3);
		// assertEquals("area of triangle", 3.75, triangle.getArea(), 0.0);
		assertThat(triangle.getArea()).isEqualTo(3.75);
	}

	@Test
	public void rectangle() {
		Rectangle rectangle = new Rectangle(2, 3);
		// assertEquals("area of rectangle", 6, rectangle.getArea(), 0.0);
		assertThat(rectangle.getArea()).isEqualTo(6);
	}

	@Test
	public void square() {
		Square square = new Square(2);

		// assertEquals("area of square", 4, square.getArea(), 0.0);
		assertThat(square.getArea()).isEqualTo(4);

		assertEquals("width and height of a square must be equal",
			square.getWidth(), square.getHeight(), 0.1);

		assertThat(square).isInstanceOf(Rectangle.class);
	}

	@Test
	public void listOfShapes() {
		List<Shape> shapes = new ArrayList<>();
		shapes.add(new Circle(4));
		shapes.add(new Square(2));
		shapes.add(new Square(2));
		shapes.add(new Rectangle(2, 3));
		shapes.add(new Triangle(3, 2));

		// Uncomment to see results of toString().
		// System.out.println(shapes);

		// 5 since lists allow duplicates
		assertEquals(5, shapes.size());
	}

	@Test
	public void setOfShapes() {
		Set<Shape> shapes = new HashSet<>();
		shapes.add(new Circle(4));
		shapes.add(new Circle(4));
		shapes.add(new Circle(4));
		shapes.add(new Square(2));
		shapes.add(new Square(2));
		shapes.add(new Rectangle(2, 3));
		shapes.add(new Rectangle(2, 3));
		shapes.add(new Triangle(3, 2));
		shapes.add(new Triangle(3, 2));

		// Uncomment to see results of toString().
		// System.out.println(shapes);

		// 4 since sets don't allow duplicates, AND since
		// we implemented 
		assertEquals(4, shapes.size());
	}

}
