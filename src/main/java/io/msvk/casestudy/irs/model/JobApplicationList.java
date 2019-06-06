package io.msvk.casestudy.irs.model;

import java.util.List;

/**
 * Bean class for list of job applications
 * @author Manish
 *
 */
public class JobApplicationList {

	private List<JobApplication> applicationList;
	private int size;
	
	public JobApplicationList() {}
	
	public JobApplicationList(List<JobApplication> applicationList, int size) {
		this.applicationList = applicationList;
		this.size = size;
	}
	public List<JobApplication> getApplicationList() {
		return applicationList;
	}
	public void setApplicationList(List<JobApplication> applicationList) {
		this.applicationList = applicationList;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
}