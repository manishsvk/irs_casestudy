package io.msvk.casestudy.irs.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import io.msvk.casestudy.irs.model.Job;
import io.msvk.casestudy.irs.dao.IJobDAO;

/**
 * Class for Database layer for jobs flow
 * @author Manish
 *
 */
@Repository
public class JobDAOImpl implements IJobDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;
	private int ctr = 0;

	class JobRowMapper implements RowMapper<Job> {
		@Override
		public Job mapRow(ResultSet rs, int rowNum) throws SQLException {
			Job job = new Job();
			job.setJobId(rs.getString("jobid"));
			job.setJobName(rs.getString("jobname"));
			job.setJobDescr(rs.getString("jobdescr"));
			job.setLocation(rs.getString("location"));
			job.setCompanyName(rs.getString("companyname"));
			job.setMinExperience(rs.getString("minexperience"));
			job.setSkills(rs.getString("skills"));
			job.setStatus(rs.getString("status"));
			job.setSubmittedBy(rs.getString("submittedby"));
			return job;
		}
	}
	
	public List<Job> findAllJobs() {
		return jdbcTemplate.query("select * from job", new JobRowMapper());
	}

    public Job findJobById(String id) {
        return jdbcTemplate.queryForObject("select * from job where jobid=?", new Object[] { id },
            new BeanPropertyRowMapper<Job> (Job.class));
    }

	public int insert(Job job) {
		return jdbcTemplate.update("insert into job values(?, ?, ?, ?, ?, ?, ?, ?, ?)",
				new Object[] {
						"J-" + ++ctr, job.getJobName(), job.getJobDescr(), job.getLocation(), 
						job.getCompanyName(), job.getMinExperience(), job.getSkills(), "open",
						job.getSubmittedBy()
		});
	}

	public int update(String jobId, Job job) {
		return jdbcTemplate.update("update job " + " set status = ?" + " where jobid = ?",
				new Object[] {
						job.getStatus(), jobId
		});
	}
}