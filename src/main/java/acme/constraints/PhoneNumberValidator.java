
package acme.constraints;

import javax.validation.ConstraintValidatorContext;

import acme.client.components.validation.AbstractValidator;
import acme.client.components.validation.Validator;

@Validator
public class PhoneNumberValidator extends AbstractValidator<ValidPhoneNumber, String> {
	// ConstraintValidator interface ------------------------------------------

	@Override
	public void initialize(final ValidPhoneNumber annotation) {
		assert annotation != null;
	}

	@Override
	public boolean isValid(final String phoneNumber, final ConstraintValidatorContext context) {

		boolean result;

		boolean validFormat = true;

		if (!phoneNumber.matches("^\\+?\\d{6,15}$"))
			validFormat = false;

		super.state(context, validFormat, "phoneNumber", "acme.validation.wrongPhoneNumber.message");

		result = !super.hasErrors(context);
		return result;
	}
}
