package lombokExercice;

import static org.junit.Assert.*;

import org.junit.Test;

public class PersonTest {

	Person person1 = new Person("James", 35);
	Adress adress1 = new Adress("Bcn", 8204, "Rambla, 45", "Cat");
	
	@Test
	public void checkName() {
		assertEquals("James", person1.getName());
	}

//	@Test
//	public void checkAge() {
//		assertThat(actual, matcher);
//	}

}
