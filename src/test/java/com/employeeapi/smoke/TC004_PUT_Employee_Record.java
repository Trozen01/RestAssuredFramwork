package com.employeeapi.smoke;

import io.restassured.RestAssured;
import io.restassured.http.Method;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeapi.base.TestBase;
import com.employeeapi.utility.RestUtils;

public class TC004_PUT_Employee_Record extends TestBase {

	String ename=RestUtils.empName();
	String ejob = RestUtils.empjob();
	
	@BeforeClass
	public void CreateEmployee() throws InterruptedException{
		
		RestAssured.baseURI="https://reqres.in/api";
		
		//Request object.
		 httpRequest = RestAssured.given();
		
		//Point 1:-Reqquest payload sending along with post request.
		JSONObject requestParams= new JSONObject();
		requestParams.put("name",ename);
		requestParams.put("Job",ejob);
		
		//Point 2:-what kind of Request data we send with API (we need specify in header we are sending data in JSON format)
		httpRequest.header("Contact-type","application/json");
		
		
		// point 1 and 2 we need send along with request  
		httpRequest.body(requestParams.toJSONString());
		
		//Response Object
		response = httpRequest.request(Method.PUT,"/users/+?/id+=/empID");
			
	}
	
	@Test
	public void checkResponsebody() {

		// ************Checking Response Body************
		// logger.info("************Checking Response Body************");
		String responsebody = response.getBody().asString();
		System.out.println("Response body is:-" + responsebody);
		Assert.assertTrue(responsebody != null);
		
	}

	@Test
	public void checkStatuscode() {

		// ************Checking Status Code************
		// logger.info("************Checking Status Code************");
		int StatusCode = response.getStatusCode();
		System.out.println("Status code is:-" + StatusCode);
		Assert.assertEquals(StatusCode, 200);
	}
	
	@Test
	public void checkResponseTime() {

		// ************Checking Response Time************
		// logger.info("************Checking Response Time************");
		long responsetime = response.getTime();
		System.out.println("Response time is:" + responsetime);
	}

	@Test
	public void checkStatusLine() {

		// ************Checking Status line************
		// logger.info("************Checking Status line************");
		String Statusline = response.statusLine();
		System.out.println("status line is: " + Statusline);
		Assert.assertEquals(Statusline, "HTTP/1.1 200 OK");

	}

	@Test
	public void checkContentType() {

		// ************Checking content type************
		// logger.info("************Checking content type************");
		String contentype = response.header("content-type");
		System.out.println("Content type is:-" + contentype);
		Assert.assertEquals(contentype, "application/json; charset=utf-8");

	}
	
	@Test
	public void checkServerType() {

		// ************Checking Server type************
		// logger.info("************Checking Server type************");
		String Servertype = response.header("Server");
		System.out.println("Server type is:-" + Servertype);
		Assert.assertEquals(Servertype, "cloudflare");

	}	

	@Test
	public void contentLenght() {

		// ************Checking Content_lenght************
		// logger.info("************Checking Content_lenght************");
		String contentlength = response.header("Content-Length");
		// int a =Integer.parseInt(contentlength);
		// if(Integer.parseInt(contentlength)<15000)
		// System.out.println("Content length is less then 1500");

		 Assert.assertTrue(Integer.parseInt(contentlength)<1500);
		System.out.println("Content length is less then 1500");
	}
	
	@AfterClass
	public void tearDown() {

		// logger.info("************Finished API Execution.************");
		System.out.println("Finished API Execution.");
	}
}
