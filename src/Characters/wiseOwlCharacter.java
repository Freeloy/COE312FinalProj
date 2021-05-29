package Characters;

public class wiseOwlCharacter extends Character {
	public wiseOwlCharacter()
	{
		super ("WiseOwl");
	}

	@Override
	public void talk() {
		System.out.println("\nWiseOwl: Hoot Hoot, Well Hello there fellow Adventurer. I have lost a precious item in one of these 2 unique\n"
				+ "         trees. (Maple tree, Pine tree). Do you mind Shaking one of them for me, You will be Rewarded if\n"
				+ "         you find my precious item. Becareful though, one of these trees has a sleeping Enemy Hiding inside it\n"
				+ "         and you only have 1 try to SHAKE.\n");
		
	}

	@Override
	public void startThread() {
		// TODO Auto-generated method stub
		
	}
}

