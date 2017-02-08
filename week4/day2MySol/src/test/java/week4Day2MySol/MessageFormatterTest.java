package week4Day2MySol;

import static org.junit.Assert.*;

import org.junit.Test;

public class MessageFormatterTest {
	MessageFormatter messageFormatter = MessageFormatterFactory.createDefaultFormatter();
	MessageFormatter messageFormatter2 = MessageFormatterFactory.createHtmlFormatter();
	MessageFormatter messageFormatter3 = MessageFormatterFactory.createDefaultFormatter2();
	//MessageFormatter messageFormatter3 = MessageFormatterFactory.createConsoleFormatter();
	//MessageFormatter messageFormatter4 = MessageFormatterFactory.createHtmlFormatter();
	
	@Test
	public void test() {
		assertEquals("Hello!", messageFormatter.format("Hello"));
		assertEquals("<strong>Hello</strong>", messageFormatter2.format("Hello"));
		assertEquals("Hola!", messageFormatter3.format("Hola"));
		assertNotEquals(messageFormatter, messageFormatter2);
	}

}
