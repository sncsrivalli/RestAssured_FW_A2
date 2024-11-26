package github.CRUDOperations;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import genericUtils.IConstantEndPointsAndPaths;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;

public class ListReposForAuthUserTest extends BaseClass {
	
	@Test
	public void listAuthUserRepos() {
		Response response = given()
								.auth()
									.oauth2(property.fetchParameter("token"))
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
