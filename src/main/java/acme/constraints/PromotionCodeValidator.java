
package acme.constraints;

import javax.validation.ConstraintValidatorContext;

import acme.client.components.validation.AbstractValidator;
import acme.client.components.validation.Validator;
import acme.client.helpers.MomentHelper;

@Validator
public class PromotionCodeValidator extends AbstractValidator<ValidPromotionCode, String> {

	// ConstraintValidator interface ------------------------------------------

	@Override
	public void initialize(final ValidPromotionCode annotation) {
		assert annotation != null;
	}

	@Override
	public boolean isValid(final String promotionCode, final ConstraintValidatorContext context) {

		boolean validFormat = true;
		boolean validYear = true;

		if (promotionCode != null && !promotionCode.isEmpty()) {
			if (!promotionCode.matches("^[A-Z]{4}-[0-9]{2}$"))
				validFormat = false;

			String yearSuffix = promotionCode.substring(promotionCode.length() - 2);
			Integer currentYear = MomentHelper.getCurrentMoment().getYear();
			String currentYearLastTwoDigits = String.valueOf(currentYear % 100);

			if (!yearSuffix.equals(currentYearLastTwoDigits))
				validYear = false;
		}

		if (promotionCode != null && !promotionCode.isEmpty()) {
			super.state(context, validFormat, "promotionCode", "acme.validation.PromotionCode.message");
			super.state(context, validYear, "promotionCode", "acme.validation.PromotionCode.message");
		}

		boolean result = promotionCode == null || promotionCode.isEmpty() || !super.hasErrors(context);
		return result;
	}

}
