
package util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

/**
 * @author Sam Brannen
 */
public class StackTests {

	private final Stack<String> stack = new Stack<>();

	@Test
	public void pushAndPeek() {
		assertThat(stack.peek()).isNull();

		stack.push("A");
		assertThat(stack.peek()).isEqualTo("A");

		stack.push("B");
		assertThat(stack.peek()).isEqualTo("B");
	}

	@Test
	public void pop() {
		assertThat(stack.pop()).isNull();

		stack.push("A");
		stack.push("B");

		assertThat(stack.pop()).isEqualTo("B");
		assertThat(stack.pop()).isEqualTo("A");
		assertThat(stack.pop()).isNull();
	}

	@Test
	public void size() {
		assertThat(stack.size()).isEqualTo(0);

		stack.push("A");
		assertThat(stack.size()).isEqualTo(1);

		stack.push("B");
		assertThat(stack.size()).isEqualTo(2);

		stack.pop();
		assertThat(stack.size()).isEqualTo(1);

		stack.pop();
		assertThat(stack.size()).isEqualTo(0);
	}

	@Test
	public void isEmpty() {
		assertThat(stack.isEmpty()).isTrue();

		stack.push("A");
		assertThat(stack.isEmpty()).isFalse();
	}

	@Test
	public void contains() {
		assertThat(stack.contains("A")).isFalse();

		stack.push("A");
		stack.push("B");
		stack.push("C");
		assertThat(stack.contains("A")).isTrue();
		assertThat(stack.contains("B")).isTrue();
		assertThat(stack.contains("C")).isTrue();
		assertThat(stack.contains("D")).isFalse();
	}

	@Test
	public void flip() {
		stack.push("A");
		stack.push("B");
		stack.push("C");

		stack.flip();

		assertThat(stack.pop()).isEqualTo("A");
		assertThat(stack.pop()).isEqualTo("B");
		assertThat(stack.pop()).isEqualTo("C");

		assertThat(stack.isEmpty()).isTrue();
	}

}
