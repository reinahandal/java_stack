
public class Gorilla extends Mammal {
	
	public void throwSomething() {
		System.out.println("The gorilla has angrily thrown a banana");
		this.energyLevel-=5;
	}
	
	public void eatBananas() {
		System.out.println("The gorilla has eaten a banana. It's very satisfied!");
		this.energyLevel+=10;
	}
	
	public void climb() {
		System.out.println("The gorilla is climbing a tree");
		this.energyLevel-=10;
	}
}
