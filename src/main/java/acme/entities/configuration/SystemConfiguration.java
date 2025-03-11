
package acme.entities.configuration;

import javax.persistence.Entity;

import acme.client.components.mappings.Automapped;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.ValidString;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class SystemConfiguration {

	// Serialisation version --------------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@Mandatory
	@ValidString(pattern = "^[A-Z]{3}$")
	@Automapped
	private String				systemCurrency;

	@Mandatory
	@ValidString(min = 3, max = 255)  //crear un valid currencies ? 
	@Automapped
	private String				acceptedCurrencies;
}
