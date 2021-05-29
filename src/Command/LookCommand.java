package Command;

import Generic.Game;
import Generic.MainPlayer;

public class LookCommand implements Command{
	MainPlayer p;
	Game g;
	public LookCommand(MainPlayer p,Game g){
		this.p=p;
		this.g=g;
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		System.out.println(g.current.description);
	}

}
