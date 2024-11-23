package petstoreUser.ResponseValidations;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;

public class ResponseBodyValidationTest {
	
	@Test
	public void getUser() {
		baseURI = "https://petstore.swagger.io/v2";
		
		Response response = when()
			.get("/user/XYZ123");
		
		response.then()
			.assertThat()
				.statusCode(200)
				.contentType(ContentType.JSON)
			.log().all();
		
		int id = response.jsonPath().get("id");
		Assert.assertEquals(id, 101);
		
		String username = response.jsonPath().get("username");
		Assert.assertEquals(username, "XYZ123");
		
		int userStatus = response.jsonPath().getInt("userStatus");
		Assert.assertEquals(userStatus, 1);
	}

}
