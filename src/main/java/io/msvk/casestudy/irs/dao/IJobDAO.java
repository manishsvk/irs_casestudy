package io.msvk.casestudy.irs.dao;

import java.util.List;

import io.msvk.casestudy.irs.model.Job;

public interface IJobDAO {

	public int insert(Job job);
	public int update(String jobId, Job job);
	public Job findJobById(String id);
	public List<Job> findAllJobs();
}
