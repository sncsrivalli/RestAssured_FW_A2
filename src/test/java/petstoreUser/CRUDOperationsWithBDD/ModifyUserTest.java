package petstoreUser.CRUDOperationsWithBDD;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class ModifyUserTest {

	@Test
	public void modifyUser() {
		baseURI = "https://petstore.swagger.io/v2";
		
		JSONObject obj = new JSONObject();
		obj.put("id", 1);
		obj.put("username", "ABCDEF");
		obj.put("firstName", "ABC");
		obj.put("lastName", "DEF");
		obj.put("email", "abcdef.123@gmail.com");
		obj.put("password", "abcdef@123#");
		obj.put("phone", "9876543102");
		obj.put("userStatus", 1);
		
		given()
			.body(obj)
			.contentType(ContentType.JSON)
		.when()
			.put("/user/ABCDEF")
		.then()
			.assertThat()
				.statusCode(200)
				.contentType(ContentType.JSON)
			.log().all();
	}
}
