
package acme.entities.service;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.validation.Optional;
import acme.client.components.validation.ValidString;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Service extends AbstractEntity {

	@ValidString(max = 50)
	@NotNull
	private String	name;

	@NotNull
	private String	imageLink;

	@NotNull
	@Min(0)
	private Double	averageDwellTime;

	@Optional
	@Column(unique = true)
	@Pattern(regexp = "^[A-Z]{4}-[0-9]{2}$", message = "Invalid promotion code format")
	private String	promotionCode;

	@Min(0)
	private Double	discountedMoney;
}
