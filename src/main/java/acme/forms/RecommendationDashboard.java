
package acme.forms;

import acme.client.components.basis.AbstractForm;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecommendationDashboard extends AbstractForm {

	//API --> GOOGLE PLACES API

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------
	String						type;
	String						city;
	String						country;
	String						location;
}
