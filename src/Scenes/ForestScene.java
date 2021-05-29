package Scenes;
import Characters.*;
import Characters.MinibossCharacter;
import Characters.wiseOwlCharacter;
import Generic.Game;
import Generic.MainPlayer;
import Items.HealthPotion;
import Items.Item;
import Items.OwlVision;

public class ForestScene extends Scene  {

HealthPotion h;
public boolean shakeTree=false;
//Game g;

	//GeraltCharacter aCharact;
	MainPlayer p = MainPlayer.getInstance();
	public ForestScene(){
		
		locationName = "Forest";
		this.person=new wiseOwlCharacter();
		this.enemy=new MinibossCharacter("Monkey",100, p, 1);
		Item[] temp= {new OwlVision()};
		this.objectlist=temp;
		description = "\nThe only spot that was not attaked by the Dragon Yet. Peaceful surrounding with many beautiful sights.\n"
				+ "THE MYTHICAL WiseOwl is RIGHT THERE!!\n"
				+ "He is sitting on the tree branch way deep into the forest. Make sure to talk to him to find your way out and clear this path.\n";
		//g = Game.getInstance();
		}
	@Override
	public void identifyLocation() {
		System.out.println("\nWelcome to the forest..");
		System.out.println("You are surrounded with trees everywhere, make sure to look around to spot things that are hidden in plain site.\n");
		// east-> owl vision, maple tree-> mini Boss
		
	}

	
	/*public void talkToMiniBoss() {
		
		System.out.println("MiniBoss: YOU won't get out of here alive!");
	}

	
	public void fightMiniBoss(BasicSword b) {
		
		System.out.println("MiniBoss killed \n gaining energy!");
		h.makeItem();
	}*/

//	@Override
//	public void useObject() {
//		o.makeItem();
//		
//	}
	public void goToTree(String treeName) {
		switch(treeName.toLowerCase()) {
		case "maple":
			System.out.println("Player is shaking the tree.. MiniBoss " + enemy.name +" appeared.\n");
			shakeTree=true;
			enemy.talk();
			enemy.startThread(); //start miniboss thread to initiate fight.
			//talkToMiniBoss();
			//fightMiniBoss(p.basicSword);
			// we can add other options (swords)
			
			break;
		case "pine":
			System.out.println("\nPlayer is shaking the tree.. Strange object falls!");
			shakeTree=true;
			System.out.println("\nWiseOwl: You Shook the RIGHT TREE!! As a reward you can take my precious item.\n");
			objectlist[0].makeItem();
			canUseItem=true;
			
			p.unlockPath(1);
			
			
			break;
			
			default:
				System.out.println(treeName);
		}
	}
	@Override
	public void useObject() {
		// TODO Auto-generated method stub
		
	}
}

