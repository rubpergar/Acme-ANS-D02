
package acme.forms;

import java.util.List;

import acme.client.components.basis.AbstractForm;
import acme.client.components.datatypes.Money;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDashboard extends AbstractForm {

	// Serialisation version --------------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	List<String>				lastFiveDestinations;
	Money						moneySpentDuringLastYear;

	Integer						numberOfEconomyBookings;
	Integer						numberOfBusinessBookings;

	Money						countBookingsInLastFiveYearsCost;
	Money						avgBookingsInLastFiveYearsCost;
	Money						minBookingsInLastFiveYearsCost;
	Money						maxBookingsInLastFiveYearsCost;
	Money						devBookingsInLastFiveYearsCost;

	Integer						countBookingsNumberOfPassengers;
	Double						avgBookingsNumberOfPassengers;
	Integer						minBookingsNumberOfPassengers;
	Integer						maxBookingsNumberOfPassengers;
	Double						devBookingsNumberOfPassengers;

	// Derived attributes -----------------------------------------------------

	// Relationships ----------------------------------------------------------

}
