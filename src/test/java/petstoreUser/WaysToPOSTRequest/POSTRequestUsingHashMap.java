package petstoreUser.WaysToPOSTRequest;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class POSTRequestUsingHashMap {

	@Test
	public void createUserUsingHashMap() {
		baseURI = "https://petstore.swagger.io/v2";
		
		HashMap<String, Object> obj = new HashMap<String, Object>();
		obj.put("id", 1);
		obj.put("username", "ABCDEF");
		obj.put("firstName", "ABC");
		obj.put("lastName", "DEF");
		obj.put("email", "abcdef.123@gmail.com");
		obj.put("password", "abcdef@123#");
		obj.put("phone", "9876543210");
		obj.put("userStatus", 0);
		
		given()
			.body(obj)
			.contentType(ContentType.JSON)
		.when()
			.post("/user")
		.then()
			.assertThat()
				.statusCode(200)
				.contentType(ContentType.JSON)
			.log().all();
				
	}
}
