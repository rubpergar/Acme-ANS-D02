
package acme.entities.flightCrewMember;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.datatypes.Money;
import acme.client.components.mappings.Automapped;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import acme.client.components.validation.ValidMoney;
import acme.client.components.validation.ValidNumber;
import acme.client.components.validation.ValidString;
import acme.entities.airline.Airline;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class FlightCrewMember extends AbstractEntity {

	// Serialisation version --------------------------------------------------

	private static final long		serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@Mandatory
	@ValidString(pattern = "^[A-Z]{2-3}\\d{6}$", message = "{validation.flightCrewMember.code}")
	@Column(unique = true)
	private String					employeeCode;

	@Mandatory
	@ValidString(pattern = "^\\+?\\d{6,15}$", message = "{validation.airline.phone}")
	@Automapped
	private String					phone;

	@Mandatory
	@ValidString
	@Automapped
	private String					languageSkills;

	@Mandatory
	@Valid
	@Automapped
	private CrewAvailabilityStatus	availabilityStatus;

	@Mandatory
	@Valid
	@Automapped
	private Airline					airline;

	@Mandatory
	@ValidMoney
	@Automapped
	private Money					salary;

	@Optional
	@ValidNumber
	@Automapped
	private Integer					yearsExperience;

	private boolean					draftMode;

	// Derived attributes -----------------------------------------------------

	// Relationships ----------------------------------------------------------

	@Mandatory
	@Valid
	@ManyToOne(optional = false)
	private Flight					flight;

}
