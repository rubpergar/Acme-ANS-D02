
package acme.constraints;

import javax.validation.ConstraintValidatorContext;

import acme.client.components.principals.DefaultUserIdentity;
import acme.client.components.validation.AbstractValidator;
import acme.client.components.validation.Validator;
import acme.client.helpers.StringHelper;
import acme.realms.flightCrewMember.FlightCrewMember;

@Validator
public class CrewMemberValidator extends AbstractValidator<ValidCustomer, FlightCrewMember> {
	// ConstraintValidator interface ------------------------------------------

	@Override
	public void initialize(final ValidCustomer annotation) {
		assert annotation != null;
	}

	@Override
	public boolean isValid(final FlightCrewMember customer, final ConstraintValidatorContext context) {
		assert context != null;

		boolean result;

		if (customer == null)
			return false;

		String employeeCode = customer.getEmployeeCode();
		if (employeeCode == null || !employeeCode.matches("^[A-Z]{2,3}\\d{6}$"))
			return false;

		DefaultUserIdentity identity = customer.getIdentity();
		if (identity == null)
			return false;

		String nameInitial = identity.getName().trim().substring(0, 1);
		String surname = identity.getSurname();
		String[] parts = surname.split(" ");

		String initials = "";
		if (parts.length == 1)
			initials = nameInitial + parts[0].substring(0, 1).toUpperCase();
		else if (parts.length >= 2)
			initials = nameInitial + parts[0].substring(0, 1).toUpperCase() + parts[1].substring(0, 1).toUpperCase();

		boolean validIdentifier = StringHelper.startsWith(employeeCode, initials, true);

		super.state(context, validIdentifier, "identifierNumber", "acme.validation.manager.invalid-identifier.message");

		result = !super.hasErrors(context);

		return result;
	}

}
