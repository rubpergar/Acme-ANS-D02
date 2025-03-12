
package acme.realms.flightCrewMember;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;

import acme.client.components.basis.AbstractRole;
import acme.client.components.datatypes.Money;
import acme.client.components.mappings.Automapped;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import acme.client.components.validation.ValidMoney;
import acme.client.components.validation.ValidNumber;
import acme.client.components.validation.ValidString;
import acme.constraints.ValidCrewMember;
import acme.constraints.ValidPhoneNumber;
import acme.entities.airline.Airline;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@ValidCrewMember
public class FlightCrewMember extends AbstractRole {

	// Serialisation version --------------------------------------------------

	private static final long		serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@Mandatory
	@ValidString(pattern = "^[A-Z]{2-3}\\d{6}$", message = "{validation.flightCrewMember.code}")
	@Column(unique = true)
	private String					employeeCode;

	@Mandatory
	@ValidPhoneNumber
	@Automapped
	private String					phone;

	@Mandatory
	@ValidString(min = 1, max = 255)
	@Automapped
	private String					languageSkills;

	@Mandatory
	@Valid
	@Automapped
	private CrewAvailabilityStatus	availabilityStatus;

	@Mandatory
	@ValidMoney(min = 0, max = 1000000)
	@Automapped
	private Money					salary;

	@Optional
	@ValidNumber(min = 0, max = 100)
	@Automapped
	private Integer					yearsExperience;

	// Derived attributes -----------------------------------------------------

	// Relationships ----------------------------------------------------------

	@Mandatory
	@Valid
	@ManyToOne(optional = false)
	private Airline					airline;

}
