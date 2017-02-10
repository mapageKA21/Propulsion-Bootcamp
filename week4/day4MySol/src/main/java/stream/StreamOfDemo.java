package stream;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamOfDemo {

	public static void main(String[] args) {
		
		System.out.println("LIMIT TO 4");
		Stream.of(1,2,3,4,5,6,7,8,9,10).limit(4).forEach(System.out::println);
		
		System.out.println("PEEK AND LIMIT TO 4");
		Stream.of(1,2,3,4,5,6,7,8,9,10).peek(System.out::println).limit(4).forEach(System.out::println);
		
		System.out.println("SKIP THE FIRST 4");
		Stream.of(1,2,3,4,5,6,7,8,9,10).skip(4).forEach(System.out::println);
		
		Stream.iterate(1, n->n+1).filter(n -> n>700).limit(50).forEach(System.out::println);
	
				
				
//		strings.forEach(System.out::println);
//		System.out.println(strings);
//		System.out.println("Size" + strings.count());
//		
//		Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 5);
//		
//		numbers.forEach(System.out::println);
//		System.out.println("Size" + numbers.count());
//		
//		IntStream numbers = IntStream.of(1, 2, 3, 4, 5);
//		
//		numbers.forEach(System.out::println);
//		System.out.println("Size" + numbers.count());
		
	}

}
