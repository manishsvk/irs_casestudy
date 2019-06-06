package io.msvk.casestudy.irs.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import io.msvk.casestudy.irs.dao.IJobApplicationDAO;
import io.msvk.casestudy.irs.model.JobApplication;

/**
 * Class for Database layer for job applications flow
 * @author Manish
 *
 */
@Repository
public class JobApplicationDAOImpl implements IJobApplicationDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	private int ctr = 0;

	class JobRowMapper implements RowMapper<JobApplication> {
		@Override
		public JobApplication mapRow(ResultSet rs, int rowNum) throws SQLException {
			JobApplication jobAppln = new JobApplication();
			jobAppln.setApplicationId(rs.getString("applicationid"));
			jobAppln.setJobId(rs.getString("jobid"));
			jobAppln.setApplicantName(rs.getString("applicantname"));
			jobAppln.setApplicationStatus(rs.getString("applicationstatus"));
			jobAppln.setLinkedinUrl(rs.getString("linkedinurl"));
			jobAppln.setResumeLocation(rs.getString("resumelocation"));
			jobAppln.setScore(rs.getString("score"));
			return jobAppln;
		}
	}

	@Override
	public int submitApplication(String jobId, JobApplication applObj) {
		return jdbcTemplate.update("insert into jobapplication values(?, ?, ?, ?, ?, ?, ?)",
				new Object[] {
						"A-" + ++ctr, jobId, applObj.getApplicantName(), "submitted", 
						applObj.getLinkedinUrl(), "", applObj.getScore()
		});
	}

	@Override
	public List<JobApplication> getApplications(String jobId) {

		return jdbcTemplate.query("select * from jobapplication where jobid=?",new Object[] { jobId }, 
				new JobRowMapper());
	}
}
