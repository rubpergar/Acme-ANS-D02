
package acme.entities.airports;

import javax.persistence.Column;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.ValidString;

public class Airport extends AbstractEntity {

	// Serialisation version --------------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@Mandatory
	@ValidString(max = 50)
	private String				name;

	@Mandatory
	@Column(unique = true)
	@ValidString(pattern = "^[A-Z]{3}$")
	private String				IATAcode;

	private AirportType			scope;

	private String				city;

	private String				country;

	private String				web;

	private String				email;

	private String				phone;
}
