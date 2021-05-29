package Items;

public class BasicSword extends Item{


public BasicSword(){
	super("basic sword");

}
	@Override
	public
	void acquire() {
		System.out.println("\nAcquiring Basic sword..");
		//player.setBasicSword(this);
		
	}

	@Override
	public
	void use() {
		
		System.out.println("\nThe Sword Ignites Creating a Beam of Light\n");
		
		
	}
	@Override
	public
	void complete() {
		System.out.println("Picked up Basic Sword..\n");
		
	}

}
