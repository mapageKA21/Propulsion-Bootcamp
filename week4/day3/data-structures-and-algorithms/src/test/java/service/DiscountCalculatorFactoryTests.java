
package service;

import static java.time.DayOfWeek.FRIDAY;
import static java.time.DayOfWeek.MONDAY;
import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;
import static org.assertj.core.api.Assertions.assertThat;
import static service.DiscountCalculatorFactory.getDiscountCalculatorFor;

import java.time.DayOfWeek;
import java.util.EnumSet;

import org.junit.Test;

/**
 * @author Sam Brannen
 */
public class DiscountCalculatorFactoryTests {

	@Test
	public void weekend() {
		for (DayOfWeek dayOfWeek : EnumSet.range(SATURDAY, SUNDAY)) {
			DiscountCalculator calculator = getDiscountCalculatorFor(dayOfWeek);

			assertThat(calculator.calculateDiscountedPrice(10.0)).isEqualTo(9.0);
		}
	}

	@Test
	public void weekdays() {
		for (DayOfWeek dayOfWeek : EnumSet.range(MONDAY, FRIDAY)) {
			DiscountCalculator calculator = getDiscountCalculatorFor(dayOfWeek);

			assertThat(calculator.calculateDiscountedPrice(10.0)).isEqualTo(10.0);
		}
	}

}
