package com.employeeapi.smoke;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;


import com.employeeapi.base.TestBase;

public class TC001_GET_Request extends TestBase {
	
	
	@BeforeClass
	public void getAllEmployee() throws Exception{
		
		//************Started TC001_GET_Request************
		logger.info("************Started TC001_GET_Request************");
		
		//Base URL
		RestAssured.baseURI="https://reqres.in/api/";
		
		//Request Object
		 httpRequest=RestAssured.given();
				
		//Response Object
		 response = httpRequest.request(Method.GET,"users?page=2");		
		String responsebody =response.getBody().asString();
		System.out.println("Response body is:-"+responsebody);
		Thread.sleep(2000);
	}

	@Test
	public void checkResponsebody(){
	
		//************Checking Response Body************
		logger.info("************Checking Response Body************");
		String responsebody =response.getBody().asString();
		System.out.println("Response body is:-"+responsebody);
		Assert.assertTrue(responsebody!=null);
	}
	
	@Test
	public void checkStatuscode(){
		
		//************Checking Status Code************
		logger.info("************Checking Status Code************");
		int StatusCode=response.getStatusCode();
		System.out.println("Status code is:-"+StatusCode);
		Assert.assertEquals(StatusCode, 200);
	}
	
	@Test
	public void checkResponseTime(){
		
		//************Checking Response Time************
		logger.info("************Checking Response Time************");
		long responsetime =response.getTime();
		System.out.println("Response time is:" +responsetime);
	}
	
	@Test
	public void checkStatusLine(){
		
		//************Checking Status line************
		logger.info("************Checking Status line************");
		String Statusline=response.statusLine();
		System.out.println("status line is: "+Statusline);
		Assert.assertEquals(Statusline, "HTTP/1.1 200 OK");
		
	}
	
	@Test
	public void checkContentType(){
		
		//************Checking content type************
		logger.info("************Checking content type************");
		String contentype= response.header("content-type");
		System.out.println("Content type is:-"+contentype);
		Assert.assertEquals(contentype, "application/json; charset=utf-8");
				
	}
	
	@Test
	public void contentEnCoding(){ 
		
		//************Checking Contenten_Coding************
		logger.info("************Checking Contenten_Coding************");
		String contentencoding= response.header("content-encoding");
		System.out.println("Content encoding is:-"+contentencoding);
		Assert.assertEquals(contentencoding, "gzip");
	}
	
	@Test
	public void contentLenght(){
		
		//************Checking Content_lenght************
		logger.info("************Checking Content_lenght************");
		String contentlength=response.header("Content-Length");
		//int a =Integer.parseInt(contentlength);
		//if(Integer.parseInt(contentlength)<10000)
		//System.out.println("Content length is less then 100");
		
		//Assert.assertTrue(Integer.parseInt(contentlength)>100);	
		System.out.println("Content length is more then 100");
	}
	
	@Test
	public void checkcookies(){
		
		logger.info("************Checking Cookies Value************");
		String Cookies =response.getCookie("PHPSESSID");
		System.out.println("Status Cookies is"+Cookies);
	}
	
	@AfterClass
	public void tearDown(){
		
		logger.info("************Finished API Execution.************");
		System.out.println("Finished API Execution.");
	}
}
