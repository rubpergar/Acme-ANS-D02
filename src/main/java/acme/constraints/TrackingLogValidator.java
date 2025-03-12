
package acme.constraints;

import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import acme.client.components.validation.AbstractValidator;
import acme.entities.trackingLogs.TrackingLog;
import acme.entities.trackingLogs.TrackingLogRepository;
import acme.entities.trackingLogs.TrackingLogStatus;

public class TrackingLogValidator extends AbstractValidator<ValidTrackingLog, TrackingLog> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private TrackingLogRepository tl;

	// ConstraintValidator interface ------------------------------------------


	@Override
	protected void initialise(final ValidTrackingLog annotation) {
		assert annotation != null;
	}

	@Override
	public boolean isValid(final TrackingLog trackingLog, final ConstraintValidatorContext context) {
		// HINT: trackingLog can be null
		assert context != null;

		boolean result;

		if (trackingLog == null)
			super.state(context, false, "*", "javax.validation.constraints.NotNull.message");

		else {

			Double resolutionPercentage = trackingLog.getResolutionPercentage();
			TrackingLogStatus status = trackingLog.getStatus();
			TrackingLog lastTrackingLog = this.tl.getLastTrackingLog(trackingLog.getClaim().getId());
			String resolution = trackingLog.getResolution();

			if (resolutionPercentage == 100 && status == TrackingLogStatus.PENDING)
				super.state(context, false, "status", "acme.validation.trackinglog.invalid-status.message");

			if (resolutionPercentage != 100 && (status == TrackingLogStatus.ACCEPTED || status == TrackingLogStatus.REJECTED))
				super.state(context, false, "status", "acme.validation.trackinglog.invalid-status.message");

			if (status != TrackingLogStatus.PENDING && (resolution == null || resolution.isBlank()))
				super.state(context, false, "resolution", "acme.validation.trackinglog.resolution-mandatory-if-status-not-pending.message");

			if (lastTrackingLog != null && lastTrackingLog.getResolutionPercentage() > trackingLog.getResolutionPercentage())
				super.state(context, false, "resolutionPercentage", "acme.validation.trackinglog.invalid-percentage.message");
		}

		result = !super.hasErrors(context);

		return result;

	}
}
