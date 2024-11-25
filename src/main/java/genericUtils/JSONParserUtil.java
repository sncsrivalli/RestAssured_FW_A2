package genericUtils;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;

import pojoClasses.GitHubRepoLibrary;

public class JSONParserUtil {

	public GitHubRepoLibrary parseJsonToJava(String jsonFilePath) {
		File obj = new File(jsonFilePath);
		ObjectMapper mapper = new ObjectMapper();
		GitHubRepoLibrary gitObj = null;
		try {
			gitObj = mapper.readValue(obj, GitHubRepoLibrary.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return gitObj;
	}
}
