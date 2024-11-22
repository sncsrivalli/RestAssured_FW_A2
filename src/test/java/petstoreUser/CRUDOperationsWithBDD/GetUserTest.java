package petstoreUser.CRUDOperationsWithBDD;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class GetUserTest {
	
	@Test
	public void getUser() {
		baseURI = "https://petstore.swagger.io/v2";
		
		when()
			.get("/user/ABCDEF")
		.then()
			.assertThat()
				.statusCode(200)
				.contentType(ContentType.JSON)
			.log().all();
	}

}
