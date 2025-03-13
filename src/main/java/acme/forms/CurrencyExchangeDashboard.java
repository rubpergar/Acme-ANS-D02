
package acme.forms;

import acme.client.components.basis.AbstractForm;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CurrencyExchangeDashboard extends AbstractForm {

	// Serialisation version --------------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	private double				eurToUsd;
	private double				eurToGbp;

	private double				usdToEur;
	private double				usdToGbp;

	private double				gbpToEur;
	private double				gbpToUsd;

}
