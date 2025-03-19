
package acme.constraints;

import java.util.ArrayList;
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

	// ConstraintValidator interface ------------------------------------------


	@Override
	public void initialize(final ValidIATACode annotation) {
		assert annotation != null;
	}

	@Override
	public boolean isValid(final String codeIATA, final ConstraintValidatorContext context) {
		assert context != null;

		boolean result;

		List<String> codesIATAs = new ArrayList<>();

		List<String> airportCodesIATAs = this.airportR.airportCodesIATAs();
		if (airportCodesIATAs != null)
			codesIATAs.addAll(airportCodesIATAs);
		else
			super.state(context, false, "*", "java.validation.constraints.NotNull.message");

		List<String> airlineCodesIATAs = this.airlineR.airlineCodesIATAs();
		if (airlineCodesIATAs != null)
			codesIATAs.addAll(airlineCodesIATAs);
		else
			super.state(context, false, "*", "java.validation.constraints.NotNull.message");

		if (codeIATA == null)
			super.state(context, false, "*", "java.validation.constraints.NotNull.message");
		else {
			if (StringHelper.isBlank(codeIATA))
				super.state(context, false, "codeIATA", "acme.validation.codeIATA.NotBlanck.message");

			if (!StringHelper.matches(codeIATA, "^[A-Z]{3}$"))
				super.state(context, false, "codeIATA", "acme.validation.codeIATA.not-valid.message");

			if (codesIATAs.contains(codeIATA))
				super.state(context, false, "codeIATA", "acme.validation.codeIATA.not-unique.message");
		}

		result = !super.hasErrors(context);

		return result;
	}

}
