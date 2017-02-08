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

/**
 * @author Sam Brannen
 * @param <T> the type of data stored in this {@code Stack}
 */
public class Stack<T> {

	// track the top of the stack internally
	private Node<T> top;

	private int size = 0;

	/**
	 * Get the size of this stack.
	 */
	public int size() {
		return this.size;
	}

	/**
	 * Determine if this stack is empty.
	 */
	public boolean isEmpty() {
		return this.size == 0;
	}

	/**
	 * Push an element onto the top of the stack.
	 */
	public void push(T element) {
		// Create new node
		Node<T> newNode = new Node<>(element);

		// Tell new node to point to the previous top of the stack
		newNode.setNext(this.top);

		// Point top to the new node
		this.top = newNode;

		this.size++;
	}

	/**
	 * Pop an element off the top of the stack and return it.
	 */
	public T pop() {
		if (this.top == null) {
			return null;
		}

		// Get top node of the stack
		Node<T> poppedNode = top;

		// Point top to the next node in the stack
		this.top = poppedNode.getNext();

		this.size--;

		// Return popped data
		return poppedNode.getData();
	}

	/**
	 * Return the element on top of the stack without removing it.
	 */
	public T peek() {
		return this.top != null ? this.top.getData() : null;
	}

	/**
	 * Determine if this stack contains the given element.
	 */
	public boolean contains(T element) {
		Node<T> current = top;
		while (current != null) {
			if (current.getData().equals(element)) {
				return true;
			}
			current = current.getNext();
		}
		return false;
	}

	/**
	 * Flip this stack on its head!
	 *
	 * <p>In other words, reverse it.
	 */
	public void flip() {
		this.top = reverse(this.top);
	}

	// top --> [A] --> [B] --x
	// x-- [A] <-- [B] <-- top
	private Node<T> reverse(final Node<T> current) {
		// if stack is empty or we are at the end of the stack
		if (current == null || current.getNext() == null) {
			return current;
		}

		Node<T> newTop = reverse(current.getNext());

		current.getNext().setNext(current);
		current.setNext(null);

		return newTop;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("Stack [");
		Node<T> current = top;
		while (current != null) {
			builder.append("\n  ");
			builder.append(current.getData());
			current = current.getNext();
		}
		builder.append("\n]");
		return builder.toString();
	}

}
