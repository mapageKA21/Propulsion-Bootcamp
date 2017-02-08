package week4Day2MySol;

class ConsoleMessageFormatter implements MessageFormatter {

	@Override
	public String format(String message) {
		return message + "!";
	}

}

