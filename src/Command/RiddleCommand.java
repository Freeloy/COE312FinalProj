package Command;

import java.io.IOException;

import Generic.*;

public class RiddleCommand implements Command{
	
	MainPlayer player;
	Game g;
	public RiddleCommand(MainPlayer player,Game g){
		this.player=player;
		this.g=g;
	}
	@Override
	public void execute() {
	
		if (!g.locationList[2].playerIsHere==true)
		{
			System.out.println("\nYou cannot do this in this location,\n");
		}
		
		else if (!g.current.person.personTalked)
		{
			System.out.println("\nYou have not unlocked this ability yet\n");
		}
		
		else {
			try {
				g.cs.riddle();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

}
