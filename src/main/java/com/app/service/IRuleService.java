package com.app.service;

import com.app.binding.CitizenInfo;
import com.app.binding.PlanInfo;

public interface IRuleService {
	public PlanInfo executeRules(CitizenInfo indvInfo);

}
