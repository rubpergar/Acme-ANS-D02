
package acme.entities.service;

import javax.persistence.Column;
import javax.persistence.Entity;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.mappings.Automapped;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import acme.client.components.validation.ValidNumber;
import acme.client.components.validation.ValidScore;
import acme.client.components.validation.ValidString;
import acme.client.components.validation.ValidUrl;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Service extends AbstractEntity {

	private static final long	serialVersionUID	= 1L;

	@Mandatory
	@ValidString(min = 1, max = 50)
	@Automapped
	private String				name;

	@Mandatory
	@ValidUrl
	@Automapped
	private String				imageLink;

	@Mandatory
	@ValidNumber(min = 0, max = 100, integer = 3, fraction = 2) //tiene que tener 2 decimales, no se si esto es asi
	@Automapped
	private Double				averageDwellTime;

	@Optional
	@ValidString(pattern = "^[A-Z]{4}-[0-9]{2}$") //validador (ver bloc de notas)
	@Column(unique = true)
	private String				promotionCode;

	@Optional
	@ValidScore
	@Automapped
	private Double				discount;
}
