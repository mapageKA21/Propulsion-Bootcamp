package strategy;


public class DiscountCalculatorFactory {

	public static DiscountCalculator getDiscountCalculatorFor(java.time.DayOfWeek day) {
		
		if (day == java.time.DayOfWeek.SATURDAY || day == java.time.DayOfWeek.SUNDAY)
			return new TenPercentDiscountCalculator();
		else
			return new ZeroDiscountCalculator();
	}

}
