package github.CRUDOperations;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import genericUtils.IConstantEndPointsAndPaths;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;
import pojoClasses.GitHubRepoLibrary;

public class CreateRepoTest extends BaseClass {

	@Test
	public void createRepo() {
		GitHubRepoLibrary obj = json.parseJsonToJava(IConstantEndPointsAndPaths.JSON_FILE_PATH);

		String repoName = obj.getName() + jutil.generateRandomNum(100);
		obj.setName(repoName);
		
		Response response = given()
								.body(obj)
								.contentType(ContentType.JSON)
								.auth()
									.oauth2(property.fetchParameter("token"))
							.when()
								.post(IConstantEndPointsAndPaths.CREATE_REPO_FOR_AUTH_USER);
		
		response.then()
					.assertThat()
						.statusCode(201)
						.contentType(ContentType.JSON)
					.log().all();
		
		String actualRepoName = response.jsonPath().get("name");
		String actualOwner = response.jsonPath().get("owner.login");
		
		Assert.assertEquals(actualRepoName, repoName);
		Assert.assertEquals(actualOwner, property.fetchParameter("owner"));	
	}
}
