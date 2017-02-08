package strategy;

public class TenPercentDiscountCalculator implements DiscountCalculator {

	@Override
	public double calculateDiscountedPrice(double price) {
		return price * 0.90;
	}

}
