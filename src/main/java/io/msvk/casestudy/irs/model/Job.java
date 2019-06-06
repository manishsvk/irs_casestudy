package io.msvk.casestudy.irs.model;

/**
 * Bean class for job entity
 * @author Manish
 *
 */
public class Job {

	private String jobId;
	private String jobName;
	private String jobDescr;
	private String location;
	private String companyName;
	private String minExperience;
	private String skills;
	private String status; // [open, closed, on-hold]
	private String submittedBy; // email address
	
	public Job(String jobId, String jobName, String jobDescr, 
			String location, String companyName, String minExperience,
			String skills, String status, String submittedBy) {
		
		
		this.jobId = jobId;
		this.jobName = jobName;
		this.jobDescr = jobDescr;
		this.location = location;
		this.companyName = companyName;
		this.minExperience = minExperience;
		this.skills = skills;
		this.status = status;
		this.submittedBy = submittedBy;
	}

	public Job() { }

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getJobDescr() {
		return jobDescr;
	}

	public void setJobDescr(String jobDescr) {
		this.jobDescr = jobDescr;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getMinExperience() {
		return minExperience;
	}

	public void setMinExperience(String minExperience) {
		this.minExperience = minExperience;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSubmittedBy() {
		return submittedBy;
	}

	public void setSubmittedBy(String submittedBy) {
		this.submittedBy = submittedBy;
	}
	
}
