
package acme.forms;

import acme.client.components.basis.AbstractForm;
import acme.entities.airports.Airport;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ManagerDashboard extends AbstractForm {

	// Serialisation version --------------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	int							rankingPosition;
	int							yearsToRetirement;

	Double						onTimeLegsRatio;
	Double						delayedLegsRatio;

	Airport						mostPopularAirport;
	Airport						leastPopularAirport;

	int							completedLegs;
	int							pendingLegs;
	int							cancelledLegs;

	Double						avgFlightCost;
	Double						minFlightCost;
	Double						maxFlightCost;
	Double						devFlightCost;

	// Derived attributes -----------------------------------------------------

	// Relationships ----------------------------------------------------------

}
