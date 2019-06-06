package io.msvk.casestudy.irs.services;

import io.msvk.casestudy.irs.model.JobApplication;
import io.msvk.casestudy.irs.model.JobApplicationList;

public interface IJobApplicationService {

	public String submitApplication(String jobId, JobApplication jobObj);
	public JobApplicationList getApplications(String jobId);
}
