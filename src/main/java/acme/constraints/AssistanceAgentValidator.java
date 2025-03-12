
package acme.constraints;

import javax.validation.ConstraintValidatorContext;

import acme.client.components.validation.AbstractValidator;
import acme.realms.AssistanceAgent;

public class AssistanceAgentValidator extends AbstractValidator<ValidAssistanceAgent, AssistanceAgent> {

	@Override
	protected void initialise(final ValidAssistanceAgent annotation) {
		assert annotation != null;
	}

	@Override
	public boolean isValid(final AssistanceAgent assistanceAgent, final ConstraintValidatorContext context) {
		assert context != null;

		boolean result;

		if (assistanceAgent == null)
			super.state(context, false, "*", "javax.validation.constraints.NotNull.message");

		else {
			String name = assistanceAgent.getUserAccount().getIdentity().getName();
			String surname = assistanceAgent.getUserAccount().getIdentity().getSurname();
			String[] surnameParts = surname.split(" ");
			String initials;

			initials = name.substring(0, 1).toUpperCase();
			initials += surnameParts[0].substring(0, 1).toUpperCase();

			if (surnameParts.length > 1)
				initials += surnameParts[1].substring(0, 1).toUpperCase();

			String code = assistanceAgent.getCode();

			boolean validCode;

			boolean validLength = code.length() >= 8 && code.length() <= 9;
			boolean validPattern = code.matches("^" + initials + "\\d{6}$");

			validCode = validLength && validPattern;

			super.state(context, validCode, "code", "acme.validation.assistanceAgent.code.message");

		}

		result = !super.hasErrors(context);

		return result;
	}

}
