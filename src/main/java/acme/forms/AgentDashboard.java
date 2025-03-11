
package acme.forms;

import java.util.Date;

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

	Date						top1MonthMoreClaims;
	Date						top2MonthMoreClaims;		//●	The top three months with the highest number of claims.  ??
	Date						top3MonthMoreClaims;

	Double						avgLogsInClaims;
	Double						minLogsInClaims;
	Double						maxLogsInClaims;
	Double						devLogsInClaims;

	Double						avgClaimsAssistedLastMonth;
	Double						minClaimsAssistedLastMonth;
	Double						maxClaimsAssistedLastMonth;
	Double						devClaimsAssistedLastMonth;
}
