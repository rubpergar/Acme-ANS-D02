
package acme.entities.reviews;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import acme.client.components.validation.ValidString;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Review extends AbstractEntity {

	// Serialisation version --------------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@Mandatory
	@ValidString(max = 50)
	private String				alias;
	@Mandatory
	private LocalDateTime		postedMoment;

	@Mandatory
	@ValidString(max = 50)
	private String				subject;

	@Mandatory
	@ValidString(max = 255)
	private String				text;

	@Optional
	@DecimalMin("0.0")
	@DecimalMax("10.0")

	private Double				score;

	@Optional
	private Boolean				recommended;

}
