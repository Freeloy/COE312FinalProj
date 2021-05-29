package Command;

import Generic.*;

public class MoveCommand {
MainPlayer player;

Game g;
	public MoveCommand(MainPlayer p,Game g){
		this.player=p; //could be done by getInstance but this forces that a main player should be already initialized.
		this.g =g;
	}
	
	public void moveWest() {
		if(g.locationList[2].playerIsHere==true) { // 2 is castle
			System.out.println("\nPlayer did not move\n");
		}
		
		else if(g.locationList[2].cannotComeBack)
		{
			System.out.println("\nYou have already completed this location.\n"
					+ "A Warrior should never look back and keep Moving Forward.\n");
		}
		
		else  {
			g.current.playerIsHere=false;
			g.locationList[2].playerIsHere=true;
			g.current = g.locationList[2];
			//g.enablePath[2] = true;
			g.current.identifyLocation();
		}
	}
	public void moveEast() {
		if(g.locationList[1].playerIsHere==true) { // 1 is forest
			System.out.println("\nPlayer did not move\n");
		}
		
		else if(g.locationList[1].cannotComeBack)
		{
			System.out.println("\nYou have already completed this location.\n"
					+ "A Warrior should never look back and keep Moving Forward.\n");
		}
		
		else  {
			g.current.playerIsHere=false;
			g.locationList[1].playerIsHere=true;
			g.current = g.locationList[1];
			//g.enablePath[1] = true;
			g.current.identifyLocation();
		}
	}
	public void moveSouth() {
		if (g.MountainPathUnlocked())
		{
		
		if(g.locationList[3].playerIsHere==true) { // 3 is mountain
			System.out.println("\nPlayer did not move\n"); //have to add bool to activate the mountain location
		}
		else{
			g.current.playerIsHere=false;
			g.locationList[3].playerIsHere=true;
			g.current = g.locationList[3];
			g.GeraltState.nextState(); //now geralt is in the mountain
			g.current.identifyLocation();
		}
	}
		else { 
			System.out.println("\nYou are not worthy to cross this path yet\n");
		}
	}
		
	public void moveNorth() {
		if(g.locationList[0].playerIsHere==true) { // 0 is Village
			System.out.println("\nPlayer did not move\n");
		}
		
		else if(g.locationList[0].cannotComeBack)
		{
			System.out.println("\nYou have already completed this location.\n"
					+ "A Warrior should never look back and keep Moving Forward.\n");
		}
		
		else  {
			g.current.playerIsHere=false;
			g.locationList[0].playerIsHere=true;
			g.current = g.locationList[0];
			g.current.identifyLocation();
		}
	}


	


}
