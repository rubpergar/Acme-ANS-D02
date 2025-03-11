
package acme.forms;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdministratorDashboard {

	// Serialisation version --------------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	int							numberAirportsByScope;
	int							numberlAirlinesByType;

	Double						airlinesWithEmailAndPhoneRatio;
	Double						activeAircraftsRatio;
	Double						nonActiveAircraftsRatio;

	Double						reviewsAboveFiveRatio;

	int							countReviewsLast10Weeks;
	Double						avgReviewsLast10Weeks;
	Double						minReviewsLast10Weeks;
	Double						maxReviewsLast10Weeks;
	Double						devReviewsLast10Weeks;

	// Derived attributes -----------------------------------------------------

	// Relationships ----------------------------------------------------------
}
