
public abstract class Art {
	protected String title;
	protected String author;
	protected String description;
	
	public Art(String title, String author, String desc) {
		this.title=title;
		this.author=author;
		this.description=desc;
	}

	public abstract void viewArt();

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getDescription() {
		return description;
	}
	
}
