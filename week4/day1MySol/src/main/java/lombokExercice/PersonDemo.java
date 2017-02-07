package lombokExercice;

import lombokExercice.Adress;

public class PersonDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person person1 = new Person("James", 23);
		Adress adress1 = new Adress("Bcn", 8204, "Rambla, 45", "Cat");
		System.out.println(person1);
		System.out.println(person1);
		System.out.println(adress1);
		person1.setAdress(adress1);
		System.out.println(person1);
	}

}
