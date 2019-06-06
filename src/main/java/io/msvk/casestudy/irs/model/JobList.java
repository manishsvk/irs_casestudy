package io.msvk.casestudy.irs.model;

import java.util.List;

/**
 * Bean class for list of jobs object
 * @author Manish
 *
 */
public class JobList {

	private List<Job> jobs;
	private int jobsSize;
	
	public JobList() { }
	
	public JobList(List<Job> jobs) {
		this.jobs = jobs;
		this.setJobsSize(jobs.size());
	}

	public List<Job> getJobs() {
		return jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}

	public int getJobsSize() {
		return jobsSize;
	}

	public void setJobsSize(int jobsSize) {
		this.jobsSize = jobsSize;
	}
}
