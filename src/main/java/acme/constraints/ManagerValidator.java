
package acme.constraints;

import javax.validation.ConstraintValidatorContext;

import acme.client.components.principals.DefaultUserIdentity;
import acme.client.components.validation.AbstractValidator;
import acme.client.components.validation.Validator;
import acme.client.helpers.StringHelper;
import acme.realms.Manager;

@Validator
public class ManagerValidator extends AbstractValidator<ValidManager, Manager> {

	// Internal state ---------------------------------------------------------

	// ConstraintValidator interface ------------------------------------------

	@Override
	protected void initialise(final ValidManager annotation) {
		assert annotation != null;
	}

	@Override
	public boolean isValid(final Manager manager, final ConstraintValidatorContext context) {
		// HINT: manager can be null
		assert context != null;

		boolean result;

		if (manager == null)
			super.state(context, false, "*", "javax.validation.constraints.NotNull.message");
		else {
			DefaultUserIdentity identity = manager.getIdentity();
			boolean hasValidIdentity = identity != null && identity.getName() != null && identity.getSurname() != null;

			super.state(context, hasValidIdentity, "identifierNumber", "acme.validation.manager.null-identity.message");

			if (hasValidIdentity) {
				// Dividir los apellidos en caso de que haya más de uno
				String[] surnames = identity.getSurname().trim().split("\\s+");
				String initials = identity.getName().trim().substring(0, 1); // Primera letra del nombre

				// Primera letra del primer apellido
				if (surnames.length > 0)
					initials += surnames[0].substring(0, 1);
				// Primera letra del segundo apellido si existe
				if (surnames.length > 1)
					initials += surnames[1].substring(0, 1);

				boolean validIdentifier = StringHelper.startsWith(manager.getIdentifierNumber(), initials, true);

				super.state(context, validIdentifier, "identifierNumber", "acme.validation.manager.invalid-identifier.message");
			}
		}

		result = !super.hasErrors(context);

		return result;
	}

}
