package io.msvk.casestudy.irs.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.msvk.casestudy.irs.dao.IJobDAO;
import io.msvk.casestudy.irs.model.Job;
import io.msvk.casestudy.irs.model.JobList;
import io.msvk.casestudy.irs.services.IJobsService;

/**
 * This class contains the business logic of Jobs flow.
 * 
 * @author Manish
 *
 */
@Service
public class JobsServiceImpl implements IJobsService {
	
	@Autowired
    IJobDAO repository;

	@Override
	public String createJob(Job jobObj) {
		
		repository.insert(jobObj);
		return "New job created successfully";
	}
	
	@Override
	public JobList getJobsList() {
		
		List<Job> list = repository.findAllJobs();
		JobList jobListObj = new JobList();
		jobListObj.setJobs(list);
		jobListObj.setJobsSize(list.size());
		
		return jobListObj;
	}

	@Override
	public Job getJob(String jobId){
		
		return repository.findJobById(jobId);
	}

	@Override
	public String updateJob(String jobId, Job newJob) {
		
		repository.update(jobId, newJob);
		return "Job updated successfully";
	}
}