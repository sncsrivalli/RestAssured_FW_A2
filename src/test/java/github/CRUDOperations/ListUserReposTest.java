package github.CRUDOperations;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtils.IConstantEndPointsAndPaths;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ListUserReposTest extends BaseClass {

	@Test
	public void listUserRepos() {
		Response response = given()
								.pathParam("username", property.fetchParameter("username"))
								.queryParam("sort", property.fetchParameter("sort"))
								.queryParam("direction", property.fetchParameter("direction"))
							.when()
								.get(IConstantEndPointsAndPaths.LIST_USER_REPOS);
		response.then()
					.assertThat()
						.statusCode(200)
						.contentType(ContentType.JSON)
					.log().all();
		String actualOwner = response.jsonPath().get("[0].owner.login");
		Assert.assertEquals(actualOwner, property.fetchParameter("owner"));
	}
}
