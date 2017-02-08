
package service;

/**
 * @author Sam Brannen
 */
class TenPercentDiscountCalculator implements DiscountCalculator {

	@Override
	public double calculateDiscountedPrice(double price) {
		return 0.9 * price;
	}

}
