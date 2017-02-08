
package service;

import static java.time.DayOfWeek.FRIDAY;
import static java.time.DayOfWeek.MONDAY;
import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.DayOfWeek;
import java.util.EnumSet;

import org.junit.Test;

/**
 * @author Sam Brannen
 */
public class PricingServiceTests {

	@Test
	public void weekend() {
		for (DayOfWeek dayOfWeek : EnumSet.range(SATURDAY, SUNDAY)) {
			PricingService pricingService = new PricingService();
			pricingService.setDayOfWeek(dayOfWeek);

			assertThat(pricingService.calculatePrice(2, 5)).isEqualTo(9.0);
		}
	}

	@Test
	public void weekdays() {
		for (DayOfWeek dayOfWeek : EnumSet.range(MONDAY, FRIDAY)) {
			PricingService pricingService = new PricingService();
			pricingService.setDayOfWeek(dayOfWeek);

			assertThat(pricingService.calculatePrice(2, 5)).isEqualTo(10.0);
		}
	}

}
