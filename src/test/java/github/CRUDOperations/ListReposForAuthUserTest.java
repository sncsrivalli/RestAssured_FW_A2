package github.CRUDOperations;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtils.IConstantEndPointsAndPaths;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ListReposForAuthUserTest extends BaseClass {
	
	@Test
	public void listAuthUserRepos() {
		Response response = given()
								.auth()
									.oauth2(property.fetchParameter("token"))
								.queryParam("sort", property.fetchParameter("sort"))
								.queryParam("direction", property.fetchParameter("direction"))
							.when()
								.get(IConstantEndPointsAndPaths.LIST_AUTH_USER_REPOS);
		response.then()
					.assertThat()
						.statusCode(200)
						.contentType(ContentType.JSON)
					.log().all();
		
		String actualOwner = response.jsonPath().get("[0].owner.login");
		Assert.assertEquals(actualOwner, property.fetchParameter("owner"));
		
	}

}
