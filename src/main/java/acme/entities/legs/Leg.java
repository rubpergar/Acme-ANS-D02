
package acme.entities.legs;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.ValidString;
import acme.entities.aircrafts.Aircraft;
import acme.entities.airports.Airport;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Leg extends AbstractEntity {

	// Serialisation version --------------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@Mandatory
	@Column(unique = true)
	@ValidString(pattern = "^[A-Z]{2}\\d{4}$")
	private String				flightNumber;

	@Mandatory
	private LocalDateTime		scheduledDeparture;

	@Mandatory
	private LocalDateTime		scheduledArrival;

	@Mandatory
	private Double				duration;

	@Mandatory
	private Status				status;

	@Mandatory
	@ManyToOne
	private Airport				departureAirport;

	@Mandatory
	@ManyToOne
	private Airport				arrivalAirport;

	@Mandatory
	@ManyToOne
	private Aircraft			aircraft;

}
