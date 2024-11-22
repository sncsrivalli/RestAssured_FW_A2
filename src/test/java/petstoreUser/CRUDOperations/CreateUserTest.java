package petstoreUser.CRUDOperations;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CreateUserTest {

	@Test
	public void createUser() {
		// Step 1: Create prerequisites - body, parameters, content type, authentications
		JSONObject obj = new JSONObject();
		obj.put("id", 1);
		obj.put("username", "ABCDEF");
		obj.put("firstName", "ABC");
		obj.put("lastName", "DEF");
		obj.put("email", "abcdef.123@gmail.com");
		obj.put("password", "abcdef@123#");
		obj.put("phone", "9876543210");
		obj.put("userStatus", 0);
		
		RequestSpecification request = RestAssured.given();
		request.body(obj);
		request.contentType(ContentType.JSON);
		
		// Step 2: Send the request
		Response response = request.post("https://petstore.swagger.io/v2/user");
		
		// Step 3: Validate response
		ValidatableResponse valResponse = response.then();
		valResponse.assertThat().statusCode(200);
		valResponse.assertThat().contentType(ContentType.JSON);
		valResponse.log().all();
	}
}
