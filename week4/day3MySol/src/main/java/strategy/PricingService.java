package strategy;

import java.time.DayOfWeek;

public class PricingService {
	
	private DayOfWeek day;
	
	public double calculatePrice(double quantity, double amount) {
		DiscountCalculator discount = DiscountCalculatorFactory.getDiscountCalculatorFor(this.day);
				
		return discount.calculateDiscountedPrice(quantity * amount);
	}

	public DayOfWeek getDay() {
		return this.day;
	}

	public void setDay(DayOfWeek day) {
		this.day = day;
	}
	
}
