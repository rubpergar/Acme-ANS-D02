
package acme.forms;

import acme.client.components.basis.AbstractForm;
import acme.entities.flightAssignment.FlightAssignment;
import acme.realms.flightCrewMember.FlightCrewMember;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FlightCrewMemberDashboard extends AbstractForm {

	// Serialisation version --------------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	String						last5Destinations;

	int							legsWithIndicentSeverityBetween0and3;
	int							legsWithIndicentSeverityBetween4and7;
	int							legsWithIndicentSeverityBetween8and10;

	FlightCrewMember			lastFlightCrewMembers;

	FlightAssignment			confirmedFlightAssignments;
	FlightAssignment			pendingFlightAssignments;
	FlightAssignment			cancelledFlightAssignments;

	Double						avgFlightAssignmentsLastMonth;
	Double						minFlightAssignmentsLastMonth;
	Double						maxFlightAssignmentsLastMonth;
	Double						devFlightAssignmentsLastMonth;

	// Derived attributes -----------------------------------------------------

	// Relationships ----------------------------------------------------------

}
