package com.employeeapi.base;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestBase {

	public static RequestSpecification httpRequest;   //Request Object
	public static Response response;                 //Response Object
	public int empID= 1 ; // hard coded -input for get details of single employee & update employee
	
	public Logger logger;  // for create logs.
	
	@BeforeClass
	public void setup(){
		
       logger=Logger.getLogger("EmployeeRestApi");
       PropertyConfigurator.configure("D://jitu//migration//selenium//RestAssuredFramwork//src//test//resources//log4j.properties");
       logger.setLevel(Level.DEBUG);
	}
}
