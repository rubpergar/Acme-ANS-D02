
package acme.entities.customers;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import acme.client.components.validation.Optional;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Customer {

	@Id
	@Pattern(regexp = "^[A-Z]{2,3}\\d{6}$", message = "Invalid identifier code format")
	private String	id;

	@Pattern(regexp = "^\\+?\\d{6,15}$", message = "Invalid phone number format")
	private String	phoneNumber;

	@Size(max = 255)
	private String	physicalAddress;

	@Size(max = 50)
	private String	city;

	@Size(max = 50)
	private String	country;

	@Optional
	@Max(500000)
	private Integer	earnedPoints;

}
