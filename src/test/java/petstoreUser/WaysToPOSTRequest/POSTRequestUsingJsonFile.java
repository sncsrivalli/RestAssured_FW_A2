package petstoreUser.WaysToPOSTRequest;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class POSTRequestUsingJsonFile {

	@Test
	public void createUserUsingHashMap() {
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
			.log().all();
				
	}
}
