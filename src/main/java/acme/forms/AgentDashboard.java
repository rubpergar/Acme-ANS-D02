
package acme.forms;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AgentDashboard {

	// Serialisation version --------------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	Double						succesfullClaimsRatio;

	Double						rejectedClaimsRatio;

	String						top3Months;

	Double						avgLogsInClaims;
	Double						minLogsInClaims;
	Double						maxLogsInClaims;
	Double						devLogsInClaims;

	Double						avgClaimsAssistedLastMonth;
	Double						minClaimsAssistedLastMonth;
	Double						maxClaimsAssistedLastMonth;
	Double						devClaimsAssistedLastMonth;
}
