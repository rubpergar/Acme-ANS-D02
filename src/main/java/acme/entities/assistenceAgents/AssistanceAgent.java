
package acme.entities.assistenceAgents;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ManyToOne;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.datatypes.Money;
import acme.client.components.mappings.Automapped;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import acme.client.components.validation.ValidMoment;
import acme.client.components.validation.ValidMoney;
import acme.client.components.validation.ValidString;
import acme.client.components.validation.ValidUrl;
import acme.entities.airline.Airline;

public class AssistanceAgent extends AbstractEntity {

	// Serialisation version --------------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@Mandatory
	@ValidString(pattern = "^[A-Z]{2-3}\\d{6}$")
	@Column(unique = true)
	private String				code;

	@Mandatory
	@ValidString(max = 255)
	@Automapped
	private String				languages;

	@Mandatory
	@ManyToOne(optional = false)
	@Automapped
	private Airline				airline;

	@Mandatory
	@ValidMoment(past = true)
	@Automapped
	private Date				moment;

	@Optional
	@ValidString(max = 255)
	@Automapped
	private String				bio;

	@Optional
	@ValidMoney
	@Automapped
	private Money				salary;

	@Optional
	@ValidUrl
	@Automapped
	private String				photo;
}
