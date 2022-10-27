
public class Bat extends Mammal {

	public Bat() {
		this.energyLevel = 300;
	}
	
	public void fly() {
		System.out.println("wooosh");
		this.energyLevel-=50;
	}
	public void eatHumans() {
		System.out.println("AAAAAAAH");
		this.energyLevel+=25;
	}
	public void attackTown() {
		System.out.println("WE'RE ON FIRE!!!");
		this.energyLevel-=100;
	}
}
