package Items;

public class GeraltSwordItem extends Item {

	public GeraltSwordItem() {
		super("Geralt sword");
		
	}

	public void acquire() {
		System.out.println("\nAcquiring geralt sword..");
		
	}

	public void use() {
		System.out.println("\nThe blade emits a deathly emerald glow!\n");
		
	}

	public void complete() {
		// TODO Auto-generated method stub
		System.out.println("Picked up Geralt Sword..\n");
	}

}

