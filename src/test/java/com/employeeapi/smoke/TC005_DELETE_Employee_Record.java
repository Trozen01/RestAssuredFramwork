package com.employeeapi.smoke;

import io.restassured.RestAssured;
import io.restassured.http.Method;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeapi.base.TestBase;

public class TC005_DELETE_Employee_Record extends TestBase {

	@BeforeClass
	public void CreateEmployee() throws InterruptedException{
		
		RestAssured.baseURI="https://reqres.in/api";
		
		//Request object.
		 httpRequest = RestAssured.given();
		
		//Response Object
		response = httpRequest.request(Method.PUT,"/users/+?/id+=/empID");
			
		System.out.println("Response is:-"+response);
	}
	
	@Test
	public void checkStatuscode() {

		// ************Checking Status Code************
		// logger.info("************Checking Status Code************");
		int StatusCode = response.getStatusCode();
		System.out.println("Status code is:-" + StatusCode);
		Assert.assertEquals(StatusCode, 200);
	}
}
