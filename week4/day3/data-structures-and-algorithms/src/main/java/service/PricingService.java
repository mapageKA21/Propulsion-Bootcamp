
package service;

import static service.DiscountCalculatorFactory.getDiscountCalculatorFor;

import java.time.DayOfWeek;

/**
 * @author Sam Brannen
 */
public class PricingService {

	private DayOfWeek dayOfWeek;

	public void setDayOfWeek(DayOfWeek dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public double calculatePrice(double quantity, double amount) {
		double basePrice = quantity * amount;
		DiscountCalculator discountCalculator = getDiscountCalculatorFor(this.dayOfWeek);
		return discountCalculator.calculateDiscountedPrice(basePrice);
	}

}
