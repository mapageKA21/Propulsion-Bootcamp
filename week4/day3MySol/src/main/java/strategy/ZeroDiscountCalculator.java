package strategy;

public class ZeroDiscountCalculator implements DiscountCalculator {

	@Override
	public double calculateDiscountedPrice(double price) {
		return price;
	}

}
