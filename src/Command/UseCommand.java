package Command;

import Generic.*;

public class UseCommand implements Command{
	MainPlayer player;
	Game g;
	public UseCommand(MainPlayer player,Game g){
		this.player=player;
		this.g=g;
	}
	@Override
	public void execute() {
		
	if(g.locationList[2].playerIsHere && player.itemIndex == 1)
	{
		g.current.objectlist[player.itemIndex].use();
		g.cs.enemyAttacks();
	}
		
	else if(!g.current.canUseItem) {
		System.out.println("you do not own this item");
	}
	else {
		//System.out.println("you do not own this item");
		g.current.objectlist[player.itemIndex].use();
	}
		
	}

}
