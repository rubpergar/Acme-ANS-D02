
package acme.constraints;

import java.util.List;

import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import acme.client.components.validation.AbstractValidator;
import acme.client.components.validation.Validator;
import acme.client.helpers.StringHelper;
import acme.entities.airline.AirlineRepository;
import acme.entities.airports.AirportRepository;

@Validator
public class IATACodeValidator extends AbstractValidator<ValidIATACode, String> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private AirportRepository	airportR;

	@Autowired
	private AirlineRepository	airlineR;

	private String				type;

	// ConstraintValidator interface ------------------------------------------


	@Override
	public void initialize(final ValidIATACode annotation) {
		assert annotation != null;

		this.type = annotation.type();
	}

	@Override
	public boolean isValid(final String codeIATA, final ConstraintValidatorContext context) {
		assert context != null;

		if (codeIATA == null) {
			super.state(context, false, "codeIATA", "javax.validation.constraints.NotNull.message");
			return false;
		}

		if (StringHelper.isBlank(codeIATA)) {
			super.state(context, false, "codeIATA", "javax.validation.constraints.NotBlank.message");
			return false;
		}

		if (!StringHelper.matches(codeIATA, "^[A-Z]{3}$")) {
			super.state(context, false, "codeIATA", "validation.airline.codeIATA");
			return false;
		}

		if (this.type.equals("airport")) {
			List<String> airlineCodesIATAs = this.airlineR.airlineCodesIATAs();
			if (airlineCodesIATAs.contains(codeIATA)) {
				super.state(context, false, "codeIATA", "acme.validation.codeIATA.not-unique.message");
				return false;
			}
		} else {
			List<String> airportCodesIATAs = this.airportR.airportCodesIATAs();
			if (airportCodesIATAs.contains(codeIATA)) {
				super.state(context, false, "codeIATA", "acme.validation.codeIATA.not-unique.message");
				return false;
			}
		}

		return true;

	}

}
