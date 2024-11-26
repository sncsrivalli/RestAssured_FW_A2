package github.CRUDOperations;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtils.IConstantEndPointsAndPaths;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class SearchRepoTest extends BaseClass {

	@Test
	public void searchRepos() {
		Response response = given()
								.queryParam("q", property.fetchParameter("q"))
								.queryParam("sort", property.fetchParameter("sort"))
								.queryParam("order", property.fetchParameter("order"))
							.when()
								.get(IConstantEndPointsAndPaths.SEARCH_REPOS);
		
		response.then()
					.assertThat()
						.statusCode(200)
						.contentType(ContentType.JSON)
					.log().all();
		
		String searchResult = response.jsonPath().get("items[0].description");
		Assert.assertTrue(searchResult.toLowerCase().contains(property.fetchParameter("q")));
	}
}
