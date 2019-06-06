package io.msvk.casestudy.irs.dao;

import java.util.List;

import io.msvk.casestudy.irs.model.JobApplication;

public interface IJobApplicationDAO {

	public int submitApplication(String jobId, JobApplication applObj);
	public List<JobApplication> getApplications(String jobId);	
}