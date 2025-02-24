
package acme.entities.airports;

import javax.persistence.Column;
import javax.persistence.Entity;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import acme.client.components.validation.ValidEmail;
import acme.client.components.validation.ValidString;
import acme.client.components.validation.ValidUrl;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
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

	@Mandatory
	private AirportType			scope;

	@Mandatory
	@ValidString(max = 50)
	private String				city;

	@Mandatory
	@ValidString(max = 50)
	private String				country;

	@Optional
	@ValidUrl
	private String				web;

	@Optional
	@ValidEmail
	private String				email;

	@Optional
	@ValidString(pattern = "^\\+?\\d{6,15}$")
	private String				phone;

	//madatory? es asi esto?
	@Mandatory
	private String				landingRunway;

	@Mandatory
	private String				takeOffRunway;
}
