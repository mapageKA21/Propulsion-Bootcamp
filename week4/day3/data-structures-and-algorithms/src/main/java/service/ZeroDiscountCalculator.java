
package service;

/**
 * @author Sam Brannen
 */
class ZeroDiscountCalculator implements DiscountCalculator {

	@Override
	public double calculateDiscountedPrice(double price) {
		return price;
	}

}
