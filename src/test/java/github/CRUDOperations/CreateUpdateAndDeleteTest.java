package github.CRUDOperations;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtils.IConstantEndPointsAndPaths;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoClasses.GitHubRepoLibrary;

public class CreateUpdateAndDeleteTest extends BaseClass {
	
	@Test
	public void createUpdateDeleteRepo() {
		// Create A Repository
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
					.log().all()
					.assertThat()
						.statusCode(201)
						.contentType(ContentType.JSON);
					
		
		String actualRepoName = response.jsonPath().get("name");
		String actualOwner = response.jsonPath().get("owner.login");
		
		Assert.assertEquals(actualRepoName, repoName);
		Assert.assertEquals(actualOwner, property.fetchParameter("owner"));	
		
		// Update Repository
		obj.setDescription("Hi All");
		obj.setPrivate(true);
		response = given()
						.pathParam("owner", actualOwner)
						.pathParam("repo", actualRepoName)
						.body(obj)
						.contentType(ContentType.JSON)
						.auth()
							.oauth2(property.fetchParameter("token"))
					.when()
						.patch(IConstantEndPointsAndPaths.UPDATE_A_REPO);
						
		String actualDescription = response.jsonPath().get("description");
		boolean actualPrivate = response.jsonPath().get("private");
		
		response.then()
					.assertThat()
						.statusCode(200)
						.contentType(ContentType.JSON)
					.log().all();
		
		Assert.assertEquals(actualDescription, "Hi All");
		Assert.assertEquals(actualPrivate, true);
		
		// Delete the Repository
		response = given()
						.pathParam("owner", actualOwner)
						.pathParam("repo", actualRepoName)
						.auth()
							.oauth2(property.fetchParameter("token"))
					.when()	
						.delete(IConstantEndPointsAndPaths.DELETE_A_REPO);
		
		response.then()
					.assertThat()
					.statusCode(204)
				.log().all();
	}

}
