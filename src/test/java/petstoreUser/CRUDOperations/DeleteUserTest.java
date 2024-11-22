package petstoreUser.CRUDOperations;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class DeleteUserTest {
	
	@Test
	public void deleteUser() {
		Response response = RestAssured.delete("https://petstore.swagger.io/v2/user/ABCDEF");
		ValidatableResponse valResponse = response.then();
		valResponse.assertThat().statusCode(200);
		valResponse.log().all();
	}

}
