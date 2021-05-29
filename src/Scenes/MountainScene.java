package Scenes;

import Characters.FinalBoss;
import Characters.GeraltCharacter;
import Characters.wiseOwlCharacter;
import Generic.*;
import Items.HealthPotion;
import Items.Item;
import Items.OwlVision;
import Items.GeraltSwordItem;

public class MountainScene extends Scene implements Observer {
	HealthPotion h;
	private Subject subject;
	MainPlayer p = MainPlayer.getInstance();

	public MountainScene(Subject sub, Watch w) {
		this.subject = sub;
		subject.registerObserver(this);
		
		this.person = GeraltCharacter.getInstance();
		this.enemy = new FinalBoss("Dragon Viserion", 300, p);
		Item[] temp = { new GeraltSwordItem() };
		this.objectlist = temp;
		description = "\nFar away in the distance you can spot Geralt waiting, make sure to greet him.\n";
	}

	@Override
	public void identifyLocation() {
		System.out.print("\nYou have finally made it to the Mountain, make sure to look around to avoid any sudden surprises\n\n");

	}
	
	public void giveItem()
	{
		objectlist[0].makeItem();
		canUseItem = true;
	}
	
	public void Initiatefight(Message m) {
		// TODO Auto-generated method stub
		System.out.println( "\n" + m.payload + " has passed. " + enemy.name + " is approaching you at a dangerous speed. Get ready to fight\n");
		enemy.startThread(); //dragon fight starts
	}

	@Override
	public void useObject() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Message m) {
		// TODO Auto-generated method stub
		if(m.topic.equalsIgnoreCase("timedone"))
		{
		Initiatefight(m);
		}
		
	}

	/*
	 * public void fightDragon(GeraltSwordItem g) { g.makeItem(); canUseItem=true;
	 * //maybe no need }
	 * 
	 * 
	 * @Override public void useObject() { // TODO Auto-generated method stub
	 * 
	 * }
	 */

}
