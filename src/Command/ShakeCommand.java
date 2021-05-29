package Command;

import Generic.*;

public class ShakeCommand implements Command {
	MainPlayer player;
	Game g;
public ShakeCommand(MainPlayer player, Game g) {
	this.player=player;
	this.g=g;
}
	@Override
	public void execute() {
		if(g.locationList[1].playerIsHere==true ) {
			if(g.fs.shakeTree==true) {
				System.out.println("you can't shake tree anymore");
			}
			else {
			g.fs.goToTree(player.treeName);
			}
		}
		else {
			System.out.println("You are not surronded by trees, try moving to another location");
		}
		
		
	}

}
