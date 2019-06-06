package io.msvk.casestudy.irs.services;

import io.msvk.casestudy.irs.model.JobApplication;

public interface IProfileScore {

	public String generateScore(JobApplication applObj);
	
}
