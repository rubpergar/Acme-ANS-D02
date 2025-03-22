
package acme.constraints;

import javax.validation.ConstraintValidatorContext;

import acme.client.components.validation.AbstractValidator;
import acme.client.components.validation.Validator;

@Validator
public class LastNibbleValidator extends AbstractValidator<ValidLastNibble, String> {

	@Override
	public void initialize(final ValidLastNibble annotation) {
		assert annotation != null;
	}

	@Override
	public boolean isValid(final String lastNibble, final ConstraintValidatorContext context) {

		boolean validFormat = true;
		boolean validLength = true;

		if (lastNibble != null && !lastNibble.isEmpty())
			if (lastNibble.length() != 4)
				validLength = false;
			else
				for (char c : lastNibble.toCharArray())
					if (!Character.isDigit(c))
						validFormat = false;

		if (lastNibble != null && !lastNibble.isEmpty()) {
			super.state(context, validFormat, "lastNibble", "acme.validation.LastNibbleWrongFormat.message");
			super.state(context, validLength, "lastNibble", "acme.validation.LastNibbleWrongLength.message");
		}
		boolean result = lastNibble == null || lastNibble.isEmpty() || !super.hasErrors(context);
		return result;
	}

}
