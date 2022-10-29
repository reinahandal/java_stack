import java.util.*;

public class Museum {
	
	public static void main(String[] args) {
		Painting painting1 = new Painting("mona lisa", "leonardo da vinci", "shes always watching you", "oil");
		Painting painting2 = new Painting("the starry night", "van gogh", "so beautiful", "oil");
		Painting painting3 = new Painting("girl with a pearl earring", "johannes vermeer", "It depicts a European girl wearing \"exotic dress\", an \"oriental turban\", and what appears to be a very large pearl as an earring.", "oil");
		Sculpture sculpture1 = new Sculpture("Venus of Willendorf", "unknown", "Some scholars suggest it may have been a self-portrait made by a woman", "Stone");
		Sculpture sculpture2 = new Sculpture("David", "Michelangelo", "One of the most iconic works in all of art history", "Stone");
		List<Art> artList = Arrays.asList( painting1, painting2, painting3, sculpture1, sculpture2);
		ArrayList<Art> museum = new ArrayList<Art>();
		museum.addAll(artList);
		
		System.out.println("Original Art List: ");
		for(Art art : museum) {
			art.viewArt();
		}
		
		System.out.println("Shuffled Art List: ");
		Collections.shuffle(museum);
		for(Art art : museum) {
			art.viewArt();
		}		
	}

}
