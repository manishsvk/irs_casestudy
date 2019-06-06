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

import io.msvk.casestudy.irs.model.JobApplication;
import io.msvk.casestudy.irs.services.IJobApplicationService;

/**
 * This is the controller class for job applications rest api's
 * @author Manish
 *
 */
@RestController
@RequestMapping("/jobapplications")
public class JobApplicationController {

	@Autowired
	IJobApplicationService jobApplService;

	@RequestMapping(value = "/{jobId}", method = RequestMethod.POST,
			produces = MediaType.TEXT_PLAIN_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> submitApplication(@RequestBody JobApplication jobObj, 
			@PathVariable("jobId") String jobId) {
		try {
			return new ResponseEntity<>(jobApplService.submitApplication(jobId, jobObj), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/{jobId}", method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getApplications(@PathVariable("jobId") String jobId) {

		try {
			return new ResponseEntity<>(jobApplService.getApplications(jobId), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}