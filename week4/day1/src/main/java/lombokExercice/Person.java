package lombokExercice;

import lombok.Data;

@Data
public class Person {
	private final String name;
	private final int age;
	private Adress adress;
}
