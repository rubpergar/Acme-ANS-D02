
package acme.constraints;

import java.time.Year;

import javax.validation.ConstraintValidatorContext;

import acme.client.components.validation.AbstractValidator;
import acme.client.components.validation.Validator;

@Validator
public class PromotionCodeValidator extends AbstractValidator<ValidPromotionCode, String> {

	// ConstraintValidator interface ------------------------------------------

	@Override
	public void initialize(final ValidPromotionCode annotation) {
		assert annotation != null;
	}

	@Override
	public boolean isValid(final String promotionCode, final ConstraintValidatorContext context) {

		if (promotionCode == null || promotionCode == "")
			return true;

		boolean result;

		boolean validFormat = true;
		boolean validYear = true;

		if (!promotionCode.matches("^[A-Z]{4}-[0-9]{2}$"))
			validFormat = false;

		String yearSuffix = promotionCode.substring(promotionCode.length() - 2);
		String currentYearLastTwoDigits = String.valueOf(Year.now().getValue() % 100);

		if (!yearSuffix.equals(currentYearLastTwoDigits))
			validYear = false;

		super.state(context, validFormat, "promotionCode", "javax.validation.constraints.NotPattern.message");
		super.state(context, validYear, "promotionCode", "javax.validation.constraints.IncorrectDigits.message");

		result = !super.hasErrors(context);
		return result;
	}

}
