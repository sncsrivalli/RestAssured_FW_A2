package petstoreUser.CRUDOperations;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class GetUserTest {
	
	@Test
	public void getUser() {
		// Step 1: Create prerequisites - body, parameters, content type, authentications
		
		// Step 2: Send the request
		Response response = RestAssured.get("https://petstore.swagger.io/v2/user/ABCDEF");
		
		// Step 3: Validate response
		ValidatableResponse valResponse = response.then();
		valResponse.assertThat().statusCode(200);
		valResponse.assertThat().contentType(ContentType.JSON);
		valResponse.log().all();
	}

}
