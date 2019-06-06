package io.msvk.casestudy.irs.services;

import io.msvk.casestudy.irs.model.Job;
import io.msvk.casestudy.irs.model.JobList;

public interface IJobsService {

	public JobList getJobsList();
	public Job getJob(String jobId);
	public String updateJob(String jobId, Job jobObj);
	public String createJob(Job jobObj);
	
}
