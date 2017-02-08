package interfaceDefault;

import static org.junit.Assert.*;

import org.junit.Test;

public class StandardPasswordValidatorTest {
	
	PasswordValidator standarPasswordValidator = new StandardPasswordValidator();
	
	@Test
	public void test() {
		assertTrue(standarPasswordValidator.isValid("abcdefghi"));
		assertFalse(standarPasswordValidator.isValid("abc"));
	}

}
