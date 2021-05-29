package Items;

import Generic.Game;
import Generic.MainPlayer;

//TODO Figure out what to do with the mirror (Item/Character)
public class MagicMirrorItem extends Item{

	public MagicMirrorItem() {
		super("magic mirror");
		// TODO Auto-generated constructor stub
	}

	@Override
	
	public void acquire() {
		System.out.println("\nAcquiring Magic mirror..");
		
	}

	@Override
	
	public void use() {
		System.out.println("\nHint: you will find the dragon in the Mountain, walking South will lead you there (path to Mountain Unlocked)\n"); // what will the hint be?
	    MainPlayer p = MainPlayer.getInstance();
	    p.unlockAllPath();
	}

	@Override
	
	public void complete() {
		// TODO Auto-generated method stub
		System.out.println("Picked up Magic Mirror..\n");
	}

}

