
package acme.forms.flightsStatus;

import java.sql.Date;

import acme.client.components.basis.AbstractForm;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FlightDashboard extends AbstractForm {

	//API-> AVIATIONSTACK

	// Serialisation version --------------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	String						flightNumber;
	String						airlineName;
	FlightStatus				flightStatus; //scheduled, active, landed, cancelled, incident,diverted
	Date						flightDate;
	String						departureAirport;
	String						arrivalAirport;
	Date						arrivalTime;
	Date						departureTime;

}
