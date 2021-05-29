package Items;

import Generic.MainPlayer;

public class HealthPotion extends Item {
	MainPlayer p;

	public HealthPotion() {
		super("health potion");
		this.p = MainPlayer.getInstance();

	}

	@Override
	public void acquire() {
		System.out.println("\nAcquiring health potion..");
		countPotion++;

	}

	@Override
	public void use() {
		if (countPotion > 0) {
			if (p.restoreHealth()) {
				System.out.println("\nHealth potion consumed.. Player HP: " + p.health +"\n");
				countPotion--;
			} else {
				System.out.println("\nHealth potion cannot be consumed.. Player HP: " + p.health +"\n");
			}

		} else {
			System.out.println("\nYou don't have enough potions :) \n");
		}

	}

	@Override
	public void complete() {
		// TODO Auto-generated method stub
		System.out.println("Picked up health potion..\n"
				+ "Potions Count = " + countPotion + "\n");

	}

}
