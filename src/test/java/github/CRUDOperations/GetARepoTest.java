package github.CRUDOperations;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtils.IConstantEndPointsAndPaths;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class GetARepoTest extends BaseClass {

	@Test
	public void getARepo() {
		Response response = given()
								.pathParam("owner", property.fetchParameter("owner"))
								.pathParam("repo", property.fetchParameter("repo"))
							.when()
								.get(IConstantEndPointsAndPaths.GET_A_REPO);
		response.then()
					.assertThat()
						.statusCode(200)
						.contentType(ContentType.JSON)
					.log().all();
		
		String actualRepoName = response.jsonPath().get("name");
		String actualOwner = response.jsonPath().get("owner.login");
		
		Assert.assertEquals(actualRepoName, property.fetchParameter("repo"));
		Assert.assertEquals(actualOwner, property.fetchParameter("owner"));	
	}
}
