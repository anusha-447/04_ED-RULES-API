package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.binding.CitizenInfo;
import com.app.binding.PlanInfo;
import com.app.serviceImpl.DetermineEligibilityService;
@RestController
public class DetermineEligibilityRestController {

	
	@Autowired
	private DetermineEligibilityService eligService;
	@Autowired
	private DetermineEligibilityService eligService2;

	@PostMapping(
		value = "/determineElig", 
		produces = { "application/xml", "application/json" },
		consumes= {"application/xml", "application/json"}
	)
	public PlanInfo checkPlanEligibility(@RequestBody CitizenInfo indvInfo) {
		PlanInfo planInfo = eligService.determineEligibility(indvInfo);
		
		System.out.println(eligService.hashCode());
		System.out.println(eligService2.hashCode());
		System.out.println(planInfo);
		return planInfo;
	}
}
