
package acme.constraints;

import java.util.List;

import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import acme.client.components.validation.AbstractValidator;
import acme.client.components.validation.Validator;
import acme.client.helpers.MomentHelper;
import acme.entities.flights.Flight;
import acme.entities.legs.Leg;
import acme.entities.legs.LegRepository;

@Validator
public class FlightValidator extends AbstractValidator<ValidFlight, Flight> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private LegRepository repository;

	// ConstraintValidator interface ------------------------------------------


	@Override
	protected void initialise(final ValidFlight annotation) {
		assert annotation != null;
	}

	@Override
	public boolean isValid(final Flight flight, final ConstraintValidatorContext context) {
		// HINT: flight can be null
		assert context != null;

		boolean result;

		if (flight == null)
			super.state(context, false, "*", "javax.validation.constraints.NotNull.message");
		else {

			boolean nonOverlappingLegs = true;
			List<Leg> legs = this.repository.getLegsByFlight(flight.getId());

			if (legs.size() > 1)
				for (int i = 0; i < legs.size() - 1; i++) {
					Leg previousLeg = legs.get(i);
					Leg nextLeg = legs.get(i + 1);

					// Verificar si la llegada del primer tramo es antes de la salida del siguiente tramo
					boolean validLeg = MomentHelper.isBefore(previousLeg.getScheduledArrival(), nextLeg.getScheduledDeparture());

					if (!validLeg) {
						nonOverlappingLegs = false;
						break;
					}
				}

			super.state(context, nonOverlappingLegs, "legs", "acme.validation.flight.overlapping.message");
		}

		result = !super.hasErrors(context);

		return result;
	}

}
