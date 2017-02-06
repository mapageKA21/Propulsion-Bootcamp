package loggingExercice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Fibonacci {

	private static final Logger logger =
		    LogManager.getLogger(Fibonacci.class);
	
	static int fibonacci(int n) {
		if (n == 0) {
			return 0;
		}
		else if (n == 1) {
			return 1;
		}
		return fibonacci(n - 1) + fibonacci(n - 2);
	}

	public static void main(String[] args) {
		logger.warn("This is a warn message");
		logger.info("This is a log message");
		logger.error("This is an ERROR message");
		System.out.println(fibonacci(0));  // 0
		System.out.println(fibonacci(1));  // 1
		System.out.println(fibonacci(2));  // 1
		System.out.println(fibonacci(3));  // 2
		System.out.println(fibonacci(7));  // 13
		System.out.println(fibonacci(12)); // 144
	}
}
