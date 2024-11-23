package pojoClasses;

public class GitHubRepoLibrary {
	
	String name;
	String description;
	String homepage;
	boolean isPrivate;
	
	public GitHubRepoLibrary() {}
	
	public GitHubRepoLibrary(String name, String description, String homepage, boolean isPrivate) {
		super();
		this.name = name;
		this.description = description;
		this.homepage = homepage;
		this.isPrivate = isPrivate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getHomepage() {
		return homepage;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	public boolean isPrivate() {
		return isPrivate;
	}

	public void setPrivate(boolean isPrivate) {
		this.isPrivate = isPrivate;
	}
}
