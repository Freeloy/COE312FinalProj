package Command;

import Generic.*;

public class TalkCommand implements Command{
	
	MainPlayer player;
	Game g;
	public TalkCommand(MainPlayer player,Game g){
		this.player=player;
		this.g=g;
	}
	@Override
	public void execute() {
	
		g.current.person.talk();
		
	}

}
