package Characters;

import Generic.ConcreteSubject;
import Generic.Game;
import Generic.MainPlayer;
import Items.*;

public class GeraltCharacter extends Character {
	
	Context GeraltState;
	Game g;
	private static  GeraltCharacter instance;
	
// 2 states: talk in village diff than talk at mountain using same method (talk)-> use strategy
	public GeraltCharacter(){
		super("Geralt");
	}
	
	private GeraltCharacter(Context Gs){
		super("Geralt");
		this.GeraltState = Gs;
	}
	
	public static synchronized  GeraltCharacter getInstance (Context Gs)
	{
		if (instance == null)
		{
			instance = new  GeraltCharacter (Gs);
		}
		return instance;
	}
	public static synchronized  GeraltCharacter getInstance ()
	{
		
		return instance;
	}

	
	@Override
	public void talk() {
		g= Game.getInstance();
		
		if(GeraltState.inVillage) {
			System.out.println("\nGeralt: You look like a worthy warrior and that is why i shall give you a sword to prove yourself.\n"
					+ "        The Path to the East will lead you to the forest while the path to the West will lead you to the Castle.\n"
					+ "        Completing both paths will unlock a secret path, or Find the hidden EasterEgg to unlock the Path Faster.\n "
					+ "       You should never forget to EQUIP your SWORD or it will lead to a tragic ending.\n");
			
			g.vs.giveItem();
			//BasicSword b=new BasicSword();
		}else if(GeraltState.inMountain) {
			System.out.println("\nGeralt: You have proved yourself, i'll give you the geralt sword as a reward. Make sure to equip it before getting closer to the Mighty Dragon");
			g.ms.giveItem();
			System.out.println("You have 10 seconds to prepare yourself before the Dragon approaches you");
			g.w.t.start(); //start watch thread
			//GeraltSwordItem g=new GeraltSwordItem();
		}
		
	}

	@Override
	public void startThread() {
		// TODO Auto-generated method stub
		
	}

	
	/*public void startThread() {
		// TODO Auto-generated method stub
		
	}*/

}

