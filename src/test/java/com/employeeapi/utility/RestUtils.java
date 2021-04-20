package com.employeeapi.utility;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {
	
	public static String empName(){
		
		String generatedString =RandomStringUtils.randomAlphabetic(1);
		return ("John"+generatedString);
		
	}

	public static String empjob(){
		String jobstring = RandomStringUtils.randomAlphabetic(2);
		return("manager"+jobstring);
	}
	
	public static String empsal(){
		String empsalary= RandomStringUtils.randomNumeric(4);
		return (empsalary);
		
	}
}

// hear we Randomlly generate empname ans salary, job for Testcase3 (for post data to API)
