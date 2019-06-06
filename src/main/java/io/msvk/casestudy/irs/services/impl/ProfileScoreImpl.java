package io.msvk.casestudy.irs.services.impl;

import org.springframework.stereotype.Service;

import io.msvk.casestudy.irs.model.JobApplication;
import io.msvk.casestudy.irs.services.IProfileScore;

/**
 * This implementation class contains the logic to evaluate score of 
 * job applicant from his linked profile or resume against the skills in job 
 * 
 * @author Manish
 *
 */
@Service
public class ProfileScoreImpl implements IProfileScore {

	@Override
	public String generateScore(JobApplication applObj) {
		
		/**
		 * 1. Currently LinkedIn OAuth Api's does not provide full profile information 
		 * of users for normal users. In order to access full profile information
		 * we have to submit request to enroll in their partner program and then 
		 * they will evaluate our request. Hence this cannot be achieve in this duration.
		 * 
		 * 2. In order to get factual information from the resume by parsing the resume 
		 * document, as per my opinion we have to use natural language processing techniques
		 * which neither do i have expertise nor can be achieve in this short duration.
		 * 
		 * Therefore in order to proceed in this case study, i will randomly generate a score
		 * for each application so that our flow is complete.
		 */
		
		return ""+(int)(Math.random() * ((100 - 1) + 1)) + 1;
	}
}