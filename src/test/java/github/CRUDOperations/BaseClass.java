package github.CRUDOperations;

import static io.restassured.RestAssured.*;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import genericUtils.IConstantEndPointsAndPaths;
import genericUtils.JSONParserUtil;
import genericUtils.JavaUtility;
import genericUtils.PropertiesUtility;

public class BaseClass {
	JavaUtility jutil;
	PropertiesUtility property;
	JSONParserUtil json;
	
	@BeforeClass
	public void beforeClass() {
		jutil = new JavaUtility();
		property = new PropertiesUtility();
		json = new JSONParserUtil();
		
		property.propertiesInit(IConstantEndPointsAndPaths.PROPERTIES_PATH);
	}
	
	@BeforeMethod
	public void beforeMethod() {
		baseURI = property.fetchParameter("baseurl");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("Test Completed");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("Test Class Completed");
	}

}
