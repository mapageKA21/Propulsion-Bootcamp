package week4Day2MySol;

public class MessageFormatterFactory {
	
	private static final MessageFormatter defaultMessageFormatter = new MessageFormatter(){

		@Override
		public String format(String message) {
			return message + "!";
		}

	};
	
	private static final HtmlMessageFormatter htmlMessageFormatter = new HtmlMessageFormatter();

	// store instance in a variable and return it
	public static MessageFormatter createDefaultFormatter(){
		return defaultMessageFormatter;
	}
	
	// returning instance of anonymous inner class
	public static MessageFormatter createDefaultFormatter2(){
		return new MessageFormatter(){

			@Override
			public String format(String message) {
				return message + "!";
			}

		};
	}
	
	public static MessageFormatter createHtmlFormatter(){
		return htmlMessageFormatter;
	}
	
	
	// USING A NESTED STATIC CLASS
	@SuppressWarnings("unused")
	private static class DefaultMessageFormatter implements MessageFormatter {

		@Override
		public String format(String message) {
			return message + "!";
		}

	}
}

