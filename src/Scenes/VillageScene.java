package Scenes;

import Characters.Context;
import Characters.GeraltCharacter;
import Items.BasicSword;
import Items.Item;


public class VillageScene extends Scene {

	//Context GeraltState = new Context();
	
	public VillageScene(Context gs, BasicSword b){
		this.person= GeraltCharacter.getInstance(gs);
		Item[] temp= {b};
		this.objectlist=temp;
		description = "\nThe Dragon had no mercy. All surrounding buildings are burnt to the ground. Disintegrated bodies Everywhere.\n"
				+ "Across the distance you can see the LEGEND geralt.\n"
				+ "Make sure to talk to Geralt if you think you got what it takes to defeat the Dragon.\n";
		con = gs; //sets the same context to the Scene class aswell
		playerIsHere=true;
	}
	
	@Override
	public void identifyLocation() {
		// TODO Auto-generated method stub
		System.out.println("\nWelcome to the Village, where the villagers are starting to rebuild after the havoc caused\nby the Mighty Dragon." +
		" Look around the area and immerse yourself with the tragic situation\n");
		
	}

	public void giveItem()
	{
		objectlist[0].makeItem();
		canUseItem = true;
	}
	
	/*public void talkToMiniBoss() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fightMiniBoss(BasicSword b) {
		// TODO Auto-generated method stub
		
	}*/

	@Override
	public void useObject() {
		// TODO Auto-generated method stub
		
	}

}
