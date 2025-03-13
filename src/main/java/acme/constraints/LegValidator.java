
package acme.constraints;

import javax.validation.ConstraintValidatorContext;

import acme.client.components.validation.AbstractValidator;
import acme.client.components.validation.Validator;
import acme.client.helpers.MomentHelper;
import acme.client.helpers.StringHelper;
import acme.entities.legs.Leg;

@Validator
public class LegValidator extends AbstractValidator<ValidLeg, Leg> {

	// Internal state ---------------------------------------------------------

	// ConstraintValidator interface ------------------------------------------

	@Override
	protected void initialise(final ValidLeg annotation) {
		assert annotation != null;
	}

	@Override
	public boolean isValid(final Leg leg, final ConstraintValidatorContext context) {
		// HINT: leg can be null
		assert context != null;

		boolean result;

		if (leg == null) {
			super.state(context, false, "*", "javax.validation.constraints.NotNull.message");
			return false;
		} else {

			boolean isScheduleCorrect = MomentHelper.isBefore(leg.getScheduledDeparture(), leg.getScheduledArrival());
			super.state(context, isScheduleCorrect, "scheduledArrival", "acme.validation.leg.invalid-scheduled-arrival.message");

			boolean isFlightNumberCorrect = true;

			if (isScheduleCorrect && leg.getAirline() != null && leg.getAirline().getCodeIATA() != null) {
				String airlineIATACode = leg.getAirline().getCodeIATA();
				isFlightNumberCorrect = StringHelper.startsWith(leg.getFlightNumber(), airlineIATACode, true);
			}

			super.state(context, isFlightNumberCorrect, "flightNumber", "acme.validation.leg.invalid-flight-number.message");

		}

		result = !super.hasErrors(context);

		return result;
	}

}
