package strategy;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import strategy.DiscountCalculatorFactory;

import java.time.DayOfWeek;

public class DiscountCalculatorFactoryTest {
	private final double price = 50.0;
	DiscountCalculator discount;

	@Test
	public void zeroWeekdays() {
		discount = DiscountCalculatorFactory.getDiscountCalculatorFor(DayOfWeek.WEDNESDAY);
		assertThat(discount.calculateDiscountedPrice(price)).isEqualTo(price);
	}
	
	@Test
	public void tenWeekends() {
		discount = DiscountCalculatorFactory.getDiscountCalculatorFor(DayOfWeek.SUNDAY);
		assertThat(discount.calculateDiscountedPrice(price)).isEqualTo(0.9*price);
	}

}
