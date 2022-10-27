
public class Mammal {
	protected int energyLevel;
	
	public Mammal() {
		this.energyLevel = 100;
	}
	
	public int displayEnergy() {
		System.out.println("The energy level is: " + this.energyLevel);
		return energyLevel;
	}
}
