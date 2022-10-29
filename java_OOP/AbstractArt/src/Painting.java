
public class Painting extends Art {
	private String paintType;

	public Painting(String title, String author, String desc, String paintType) {
		super(title, author, desc);
		this.paintType=paintType;
	}

	public void viewArt() {
		System.out.println("Title: " + super.getTitle() + "\n Author: "+ this.getAuthor() + "\n Description: " + this.getDescription() + "\n Paint Type: "+ this.paintType);
		System.out.println("-------------------------------------");
		
	}

}
