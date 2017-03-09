/**
 * 
 */
package com.mywork.resumeprocessing.model.scheduleinterview;
/**
 * @author ManiKanta Kandagatla
 *
 */
import java.util.List;
import com.mywork.resumeprocessing.model.scheduleinterview.ScheduledInterview;
public class BulkScheduledInterviews {
	
	private List<ScheduledInterview> scheduledInterviews;

	public List<ScheduledInterview> getScheduledInterviews() {
		return scheduledInterviews;
	}

	public void setScheduledInterviews(List<ScheduledInterview> scheduledInterviews) {
		this.scheduledInterviews = scheduledInterviews;
	}
}
