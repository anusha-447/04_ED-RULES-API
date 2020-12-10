package com.app.serviceImpl;

import java.lang.reflect.Method;

import org.springframework.stereotype.Service;

import com.app.binding.CitizenInfo;
import com.app.binding.PlanInfo;

@Service("eligService")
public class DetermineEligibilityService {
	public PlanInfo determineEligibility(CitizenInfo indvInfo) {
		String planName = indvInfo.getPlanName();
		String clzName = "com.app.serviceImpl."+planName+"RulesExecutor";
		PlanInfo planInfo = null;
		try {
			Class<?> clz = Class.forName(clzName);
			
			Method method = clz.getDeclaredMethod("executeRules", CitizenInfo.class);
			
			Object object = clz.newInstance();
			
			planInfo =  (PlanInfo) method.invoke(object, indvInfo);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return planInfo;
	}
}
