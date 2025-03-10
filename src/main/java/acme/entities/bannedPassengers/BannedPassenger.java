
package acme.entities.bannedPassengers;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import acme.client.components.validation.ValidMoment;
import acme.client.components.validation.ValidString;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class BannedPassenger extends AbstractEntity {

	// Serialisation version --------------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@Mandatory
	@ValidString(pattern = "^[A-Za-z ]{1,50}$")
	@Column(length = 50)
	private String				fullName;

	@Mandatory
	@ValidMoment(past = true)
	@Temporal(TemporalType.DATE)
	private Date				dateOfBirth;

	@Mandatory
	@ValidString(pattern = "^[A-Z0-9]{6,9}$")
	@Column(unique = true)
	private String				passportNumber;

	@Mandatory
	@ValidString(pattern = "^[A-Za-z ]{1,50}$")
	@Column(length = 50)
	private String				nationality;

	@Mandatory
	@ValidString(pattern = "^[\\w\\s]{1,255}$")
	@Column(length = 255)
	private String				banReason;

	@Mandatory
	@ValidMoment(past = true)
	@Temporal(TemporalType.DATE)
	private Date				banIssuedDate;

	@Optional
	@ValidMoment(past = true)
	@Temporal(TemporalType.DATE)
	private Date				liftedDate;

	// Derived attributes -----------------------------------------------------

	// Relationships ----------------------------------------------------------

}
