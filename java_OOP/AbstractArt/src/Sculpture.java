
public class Sculpture extends Art {
	private String material;

	public Sculpture(String title, String author, String desc, String material) {
		super(title, author, desc);
		this.material=material;
	}

	public void viewArt() {
		System.out.println("Title: " + this.getTitle() + "\n Author: "+ this.getAuthor() + "\n Description: " + this.getDescription() + "\n Material: "+ this.material);
		System.out.println("-------------------------------------");
	}
}
