package petstoreUser.WaysToPOSTRequest;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import pojoClasses.PetstoreUserLibrary;

public class POSTRequestUsingPOJOClass {

	@Test
	public void createUser() {
		PetstoreUserLibrary obj = new PetstoreUserLibrary(2, "PQRSTU", "PQR", "STU", 
				"pqrstu@gmail.com", "pqrstu1@", "8765432109", 0);
		baseURI = "https://petstore.swagger.io/v2";
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
