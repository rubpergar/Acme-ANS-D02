
package acme.constraints;

import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import acme.client.components.validation.AbstractValidator;
import acme.client.components.validation.Validator;
import acme.entities.aircrafts.Aircraft;
import acme.entities.aircrafts.AircraftRepository;

@Validator
public class UniqueRegistrationNumberValidator extends AbstractValidator<ValidRegistrationNumber, String> {

	@Autowired
	private AircraftRepository aircraftRepository;


	@Override
	protected void initialise(final ValidRegistrationNumber annotation) {
		assert annotation != null;
	}

	@Override
	public boolean isValid(final String registrationNumber, final ConstraintValidatorContext context) {
		assert context != null;

		if (registrationNumber == null)
			super.state(context, false, "*", "javax.validation.constraints.NotNull.message");

		Aircraft existingAircraft = this.aircraftRepository.findByRegistrationNumber(registrationNumber);

		boolean isValid = existingAircraft == null || existingAircraft.getRegistrationNumber().equals(registrationNumber);

		super.state(context, isValid, "registrationNumber", "acme.validation.aircraft.duplicate-registration-number.message");

		return isValid;
	}
}
