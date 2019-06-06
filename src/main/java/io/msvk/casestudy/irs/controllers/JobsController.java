package io.msvk.casestudy.irs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.msvk.casestudy.irs.model.Job;
import io.msvk.casestudy.irs.services.IJobsService;

/**
 * This is the controller class for jobs rest api's
 * @author Manish
 *
 */
@RestController
@RequestMapping("/jobs")
public class JobsController {

	@Autowired
	IJobsService jobsService;

	@RequestMapping(value = "", method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getJobList() {
		try {
			return new ResponseEntity<>(jobsService.getJobsList(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/{jobId}", method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getJob(@PathVariable("jobId") String jobId) {
		try {
			return new ResponseEntity<>(jobsService.getJob(jobId), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/{jobId}", method = RequestMethod.PATCH,
			produces = MediaType.TEXT_PLAIN_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> updateJob(@PathVariable("jobId") String jobId, @RequestBody Job jobObj) {
		try {
			return new ResponseEntity<>(jobsService.updateJob(jobId, jobObj), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "", method = RequestMethod.POST,
			produces = MediaType.TEXT_PLAIN_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> createJob(@RequestBody Job jobObj) {
		try {
			return new ResponseEntity<>(jobsService.createJob(jobObj), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}	
}