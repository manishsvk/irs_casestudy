package io.msvk.casestudy.irs.model;

/**
 * Bean class for job application entity
 * @author Manish
 *
 */
public class JobApplication {

	private String applicationId;
	private String jobId;
	private String applicantName;
	private String applicationStatus; // [submitted, in-process, not considering]
	private String linkedinUrl;
	private String resumeLocation;
	private String score;

	public JobApplication() {}
	
	public JobApplication(String jobId, String applicationStatus, 
			String applicationId, String linkedinUrl, String applicantName,
			String resumeLocation) {
		this.applicationId = applicationId;
		this.jobId = jobId;
		this.applicationStatus = applicationStatus;
		this.linkedinUrl = linkedinUrl;
		this.resumeLocation = resumeLocation;
		this.applicantName = applicantName;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getApplicantName() {
		return applicantName;
	}

	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	public String getApplicationStatus() {
		return applicationStatus;
	}

	public void setApplicationStatus(String applicationStatus) {
		this.applicationStatus = applicationStatus;
	}

	public String getLinkedinUrl() {
		return linkedinUrl;
	}

	public void setLinkedinUrl(String linkedinUrl) {
		this.linkedinUrl = linkedinUrl;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}

	public String getResumeLocation() {
		return resumeLocation;
	}

	public void setResumeLocation(String resumeLocation) {
		this.resumeLocation = resumeLocation;
	}	
}