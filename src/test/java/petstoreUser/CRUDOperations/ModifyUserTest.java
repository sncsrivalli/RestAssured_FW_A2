package petstoreUser.CRUDOperations;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class ModifyUserTest {

	@Test
	public void modifyUser() {
		// Step 1: Create prerequisites - body, parameters, content type
		JSONObject obj = new JSONObject();
		obj.put("id", 1);
		obj.put("username", "ABCDEF");
		obj.put("firstName", "ABC");
		obj.put("lastName", "DEF");
		obj.put("email", "abcdef.123@gmail.com");
		obj.put("password", "abcdef@123#");
		obj.put("phone", "9876543201");
		obj.put("userStatus", 1);

		RequestSpecification request = RestAssured.given();
		request.body(obj);
		request.contentType(ContentType.JSON);
		
		// Step 2: Send request
		Response response = request.put("https://petstore.swagger.io/v2/user/ABCDEF");
		
		// Step 3: validate response
		ValidatableResponse valResponse = response.then();
		valResponse.assertThat().statusCode(200);
		valResponse.assertThat().contentType(ContentType.JSON);
		valResponse.log().all();
	}
}
