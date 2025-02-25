
package acme.entities.airlineManagers;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import acme.client.components.validation.ValidString;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class AirlineManager extends AbstractEntity {

	// Serialisation version --------------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@Mandatory
	@Column(unique = true)
	@ValidString(pattern = "^[A-Z]{2,3}\\d{6}$")
	private String				identifierNumber;

	@Mandatory
	private int					yearsOfExperience;

	@Mandatory
	private LocalDate			dateOfBirth;

	@Optional
	private String				pictureLink;

}
