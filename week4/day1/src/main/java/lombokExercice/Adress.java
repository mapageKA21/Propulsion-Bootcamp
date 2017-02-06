package lombokExercice;

import lombok.Data;

@Data
public class Adress {
	private final String city;
	private final int postalCode;
	private final String address;
	private final String country;
	//private final Person person;
}
