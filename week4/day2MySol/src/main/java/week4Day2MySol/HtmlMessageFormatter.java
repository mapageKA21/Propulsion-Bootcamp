package week4Day2MySol;

public class HtmlMessageFormatter implements MessageFormatter {

	@Override
	public String format(String message) {
		return "<strong>" + message + "</strong>";
	}

}
