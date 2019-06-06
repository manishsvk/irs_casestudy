package io.msvk.casestudy.irs.services.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import io.msvk.casestudy.irs.constants.IRSConstants;
import io.msvk.casestudy.irs.dao.IJobApplicationDAO;
import io.msvk.casestudy.irs.model.JobApplication;
import io.msvk.casestudy.irs.model.JobApplicationList;
import io.msvk.casestudy.irs.services.IJobApplicationService;
import io.msvk.casestudy.irs.services.IProfileScore;

/**
 * This class contains the business logic of Job Application flow.
 * 
 * @author Manish
 *
 */
@Service
public class JobApplicationServiceImpl implements IJobApplicationService {

	@Autowired
    IJobApplicationDAO repository;
	
	@Autowired
	IProfileScore profileScore;
	
	@Override
	public String submitApplication(String jobId, JobApplication applObj) {
		
		/**
		 * Score generation logic can also be async using multi threading so that 
		 * if the score calculation takes time we can continue processing the current
		 * request.
		 */
		String score = profileScore.generateScore(applObj);
		
		applObj.setScore(score);
		
		repository.submitApplication(jobId, applObj);
		return "Job application submitted successfully";
	}

	@Override
	public JobApplicationList getApplications(String jobId) {
		
		List<JobApplication> list = repository.getApplications(jobId);
		JobApplicationList appListObj = new JobApplicationList();
		appListObj.setApplicationList(list);
		appListObj.setSize(list.size());
		return appListObj;
	}
}