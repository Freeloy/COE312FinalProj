/*package Generic;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

import Scenes.ForestScene;
import Scenes.Scene;
import Scenes.VillageScene;

public class UserInterface  implements Runnable{

	MainPlayer p1;
	BufferedReader userinput;
	String endgame = "i give up"; //For losers :D

	public UserInterface(InputStream input) {
		this.userinput = new BufferedReader(new InputStreamReader(input));
		this.p1 = MainPlayer.getInstance();
		Thread t = new Thread(this);
		t.start();
		// TODO Auto-generated constructor stub
	}
	//To take other types of inputs
	public UserInterface(BufferedReader input)
	{
		userinput = input;
		this.p1 = MainPlayer.getInstance();
		Thread t = new Thread(this);
		t.start();
	}

	public UserInterface(InputStreamReader input)
	{
		this.userinput = new BufferedReader(input);
		this.p1 = MainPlayer.getInstance();
		Thread t = new Thread(this);
		t.start();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		String enterPass = "Start";
		System.out.println("Welcome to the game of BLAH BLAH, Please enter 'Start' to initiate the game\n");

		String action = null;
		try {
			action = userinput.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			//action = userinput.readLine();
		

		while (!action.toLowerCase().equals(enterPass)) {
			System.out.println("\nIncorrect Code .....try again\n");
			try {
				action = userinput.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


		VillageScene vs = new VillageScene();
		ForestScene fs = new ForestScene();
		

		
		Scene[] locationList = {vs ,fs  };
		String [] treeTypes = {"Maple", "Pine"};
		Scene current;
		int itemIndex, treeIndex; //, countPotions = 0;


		int choice = 0; // Player initially starts in village
		boolean canUseOwlVision = false, Endgame = false;
		

//while (!isDone) {
		while (!action.equals(endgame)) {

			switch (choice) {

			case 0: {
				current = locationList[0];

				current.identifyLocation();

				while (choice == 0) {
					try {
						action = userinput.readLine();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					if (action.equalsIgnoreCase("look around")) {

						System.out.println(current.description);
						}
					

					else if (action.contains("talk to")) {
						if (current.verifyCharacter(p1.extractName(action)) == true) {
							current.person.talk();
							current.con.nextState(); // Geralt goes to the mountain now and awaits you to prove yourself
						}

						else {
							System.out.println("\nThe character is not here....try again!\n");
						}

					}

					else if (action.contains("use")) {
						itemIndex = current.searchObject(p1.extractItemName(action));
						if (itemIndex == -1) {
							System.out.println("\nThe item you are looking for is not in this location\n");
						}

						else {
							current.objectlist[itemIndex].use();
						}
					}

					else if (action.contains("walk")) {
						choice = p1.Action(p1.extractDirection(action));
						if (choice == -1) {
							choice = 0; // Stay in same location
							System.out.println("\nInvalid Location, please try again.\n");
						}
					}

					else if (action.equals(endgame)) {
						break;
					}

					else {
						System.out.println("\nInvalid Command.. Please try again\n");
					}
				}
				break;
			}

			case 1: {
				current = locationList[1];

				current.identifyLocation();
				
				while (choice == 1) {
					try {
						action = userinput.readLine();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					if (action.equalsIgnoreCase("look around")) {

						System.out.println(current.description);
						}

					else if (action.contains("talk to")) {
						if (current.verifyCharacter(p1.extractName(action)) == true) {
							current.person.talk();
						}

						else {
							System.out.println("\nThe character is not here....try again!\n");
						}

					}
					
					else if (action.contains("shake")){
						treeIndex = p1.extractTreeName(action);
						if (treeIndex == 0)
						{ fs.goToTree(treeTypes[0]);}
						
						else if (treeIndex == 1)
						{ fs.goToTree(treeTypes[1]);
						  current.objectlist[0].makeItem();
						  canUseOwlVision = true;
						}
						
						else if (treeIndex == -1)
						{ System.out.println("\nThis tree doesn't exist in this forest...try again.\n");}
					}
							

					else if (action.contains("use")) {
						if (!canUseOwlVision)
						{
							System.out.println("\nYou do not own this item yet. Make sure to fully explore the forest to find it\n");
						}
						itemIndex = current.searchObject(p1.extractItemName(action));
						if (itemIndex == -1) {
							System.out.println("\nThe item you are looking for is not in this location\n");
						}

						else {
							current.objectlist[itemIndex].use();
						}
					}

					else if (action.contains("walk")) {
						choice = p1.Action(p1.extractDirection(action));
						if (choice == -1) {
							choice = 0; // Stay in same location
							System.out.println("\nInvalid Location, please try again.\n");
						}
					
					}

					else if (action.equals(endgame)) {
						break;
					}

					else {
						System.out.println("\nInvalid Command.. Please try again\n");
					}
				}
				break;
			}

			
			// stopped here, castle and mountain implementation are left here
			case 2: {
				current = locationList[2];

				current.identifyLocation();

				while (choice == 2) {
					try {
						action = userinput.readLine();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					if (action.equalsIgnoreCase("look around")) {

						System.out.println(current.description);
						}
					

					else if (action.contains("talk to")) {
						if (current.verifyCharacter(p1.extractName(action)) == true) {
							current.person.talk();
						}

						else {
							System.out.println("\nThe character is not here....try again!\n");
						}

					}

					else if (action.contains("use")) {
						itemIndex = current.searchObject(p1.extractItemName(action));
						if (itemIndex == -1) {
							System.out.println("\nThe item you are looking for is not in this location\n");
						}

						else {
							current.objectlist[itemIndex].use();
						}
					}

					else if (action.contains("walk")) {
						choice = p1.Action(p1.extractDirection(action));
						if (choice == -1) {
							choice = 0; // Stay in same location
							System.out.println("\nInvalid Location, please try again.\n");
						}
					}

					else if (action.equals(endgame)) {
						break;
					}

					else {
						System.out.println("\nInvalid Command.. Please try again\n");
					}
				}
				break;
			}
			}
		}

		Endgame = true;
		System.out.println("\nYou Lost....Game Over\n");
		System.exit(2);
	}
}
*/
	


