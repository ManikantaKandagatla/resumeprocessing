/**
 * 
 */
package com.mywork.resumeprocessing.model;
/**
 * @author ManiKanta Kandagatla
 *
 */
import java.util.List;
import com.mywork.resumeprocessing.model.ScheduledInterview;
public class BulkScheduledInterviews {
	
	private List<ScheduledInterview> scheduledInterviews;

	public List<ScheduledInterview> getScheduledInterviews() {
		return scheduledInterviews;
	}

	public void setScheduledInterviews(List<ScheduledInterview> scheduledInterviews) {
		this.scheduledInterviews = scheduledInterviews;
	}
}
