package petstoreUser.ResponseValidations;

import static io.restassured.RestAssured.*;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class ResponseHeaderValidationsTest {

	@Test
	public void createUser() {
		baseURI = "https://petstore.swagger.io/v2";
		
		File obj = new File("./src/test/resources/petstoreUserData.json");
				
		given()
			.body(obj)
			.contentType(ContentType.JSON)
		.when()
			.post("/user")
		.then()
			.assertThat()
				.statusCode(200)
				.contentType(ContentType.JSON)
				.header("Server", "Jetty(9.2.9.v20150224)")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
			.log().all();
	}
}
