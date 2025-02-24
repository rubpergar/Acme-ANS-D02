
package acme.entities.assistenceAgents;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ManyToOne;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.datatypes.Money;
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
	@Column(unique = true)
	@ValidString(pattern = "^[A-Z]{2-3}\\d{6}$") //where the first two or three letters correspond to their initials
	private String				code;

	@Mandatory
	@ValidString(max = 255)
	private String				languages; //string o list<string>??

	@Mandatory
	@ManyToOne
	private Airline				airline;

	@Mandatory
	@ValidMoment(past = true)
	private Date				moment;

	@Optional
	@ValidString(max = 255)
	private String				bio;

	@Optional								//validMoney?
	@ValidMoney
	private Money				salary;				//Money?

	@Optional
	@ValidUrl
	private String				photo;
}
