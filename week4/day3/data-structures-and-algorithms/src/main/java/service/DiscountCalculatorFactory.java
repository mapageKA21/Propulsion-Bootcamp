
package service;

import java.time.DayOfWeek;

/**
 * @author Sam Brannen
 */
public class DiscountCalculatorFactory {

	private static final TenPercentDiscountCalculator tenPercentDiscountCalculator = new TenPercentDiscountCalculator();
	private static final ZeroDiscountCalculator zeroDiscountCalculator = new ZeroDiscountCalculator();

	public static DiscountCalculator getDiscountCalculatorFor(DayOfWeek dayOfWeek) {
		switch (dayOfWeek) {
			case SATURDAY:
			case SUNDAY:
				return tenPercentDiscountCalculator;
			default:
				return zeroDiscountCalculator;
		}
	}

}
