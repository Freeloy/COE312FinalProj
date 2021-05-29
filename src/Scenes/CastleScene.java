package Scenes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Characters.MinibossCharacter;
import Characters.PrinceCharacter;
import Characters.wiseOwlCharacter;
import Generic.MainPlayer;
import Generic.UI;
import Items.BasicSword;
import Items.HealthPotion;
import Items.Item;
import Items.MagicMirrorItem;
import Items.OwlVision;

public class CastleScene extends Scene {
	HealthPotion h;

	UI u;
	MainPlayer p = MainPlayer.getInstance();

	public CastleScene(BasicSword b) {

		locationName = "Castle";
		this.person = new PrinceCharacter();
		this.enemy = new MinibossCharacter("Blazing Bull", 100, p, 2);
		Item[] temp = { new MagicMirrorItem(), b };
		this.objectlist = temp;
		description = "\nIn a dark night:O\nThe candlelight brings a natural hallowed glow to the walls.\nHowever, it is not enough to see what lies ahead.\nMake sure to USE your sword and light the way.\n"; // maybe
																																																				// add
																																																				// to
																																																				// the
																																																				// description
	}

	@Override
	public void identifyLocation() {
		System.out.println("\nWelcome to the castle! <gates opening..>");// we can use sensor to open gate
		System.out.println("An antiquated castle that has a raised bridge gate & stone brick walls\n"
				+ "Make sure to Look around and understand your surrounding.\n");
		// System.out.println("\nIn a dark night:O\nThe candlelight brings a natural
		// hallowed glow to the walls.\n"
		// + "However, it is not enough to see what lies ahead.\n"
		// +"Make sure to USE your sword and light the way\n.");

	}

	public void enemyAttacks() {
		System.out.println("You can see a person hiding far away across the corridor.\n");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Prince Luigi: HELLLLLPPPP MEEEEEEEEEE!!!!\n");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("There is a strong light beam coming towards you at a quick speed." + "\nIT IS THE "
				+ enemy.name + " GET READY TO FIGHT!!\n");

		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		enemy.startThread();
	}

	/*
	 * public void talkToMiniBoss() { // mini boss in castle is talking to the
	 * player.. System.out.
	 * println("MiniBoss: Hehehehhehehehe, you have hopes to get out of here??? Not before killing me ;) "
	 * );
	 * 
	 * } //annoying prince
	 * 
	 * @Override public void fightMiniBoss(BasicSword b) { b.makeItem();
	 * System.out.println("MiniBoss killed \n gaining energy!"); h.makeItem();
	 * 
	 * }
	 */
	
	boolean riddleFailed = false;
	
	public void riddle() throws IOException {
		if (!riddleFailed)
		{
		int countTrials = 1;
		u = UI.getInstance();
		// BufferedReader reader = new BufferedReader(
		// new InputStreamReader(System.in));

		System.out.println("\nDo you want to solve the riddle for a chance to acquire the hidden item?\nType Yes or No\n");
		String name = u.readLine();
		if (name.equalsIgnoreCase("No")) {
			System.out.println("\nOkay, you can complete your adventure.. No valuable item for you\n");
		} else if (name.equalsIgnoreCase("yes")) {
			System.out.println("\nIf I have it, I don't share it.\nIf I share it, I don't have it.\nWhat is it?");
			System.out.println("You can skip if you give up :P .You Have Only 3 trials available.\n");
			// take input from user
			name = u.readLine();
			boolean noSuccess = true;
			while (countTrials < 4 && noSuccess) {
				if (countTrials < 3 && (name.equalsIgnoreCase("secret") || name.equalsIgnoreCase("A secret"))) {
					System.out.println(
							"\nCongrats :) you have solved the riddle correctly, now you earned the valuable item(magic mirror);\n");
					useObject();
					noSuccess = false;
				} else if (countTrials >= 3) {
					countTrials++;
					System.out.println("\nOOOOPS, no more trials for you.\n");
					riddleFailed = true;
				}
				
				else if(name.equalsIgnoreCase("skip"))
				{
					countTrials = 4;
					System.out.println("\nWe got a coward here :D\n");
				}

				else {
					System.out.println("\n Incorrect answer. Tries Done: " + countTrials++ + "\n");
					name = u.readLine();

				}

			}

		}
		u.inUse = false;
		}
		
		else  System.out.println("\nYou have no more trials left.\n");
	}

	@Override
	public void useObject() {
		// we will call this function in the riddle
		// it will enable the entire path for the user (setALL)
		objectlist[0].makeItem();
		canUseItem = true;
		// System.out.println("you found the shortcut, now you can go directly to the
		// mountain, the Dragon's place!");

	}

}