package genericUtils;

public interface IConstantEndPointsAndPaths {

	String CREATE_REPO_FOR_AUTH_USER = "/user/repos";
	String LIST_AUTH_USER_REPOS = "/user/repos";
	String GET_A_REPO = "/repos/{owner}/{repo}";
	String UPDATE_A_REPO = "/repos/{owner}/{repo}";
	String DELETE_A_REPO = "/repos/{owner}/{repo}";
	String LIST_USER_REPOS = "/users/{username}/repos";
	String SEARCH_REPOS = "/search/repositories";
	
	String PROPERTIES_PATH = "./src/test/resources/parameters.properties";
	String JSON_FILE_PATH = "./src/test/resources/gitRepoData.json";
}
