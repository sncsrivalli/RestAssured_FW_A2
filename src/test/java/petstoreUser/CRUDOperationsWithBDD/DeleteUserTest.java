package petstoreUser.CRUDOperationsWithBDD;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class DeleteUserTest {

	@Test
	public void deleteUser() {
		baseURI = "https://petstore.swagger.io/v2";
		
		when()
			.delete("/user/ABCDEF")
		.then()
			.assertThat()
				.statusCode(200)
			.log().all();
	}
}
