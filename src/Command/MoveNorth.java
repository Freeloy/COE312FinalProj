package Command;



public class MoveNorth implements Command {
	MoveCommand m;
	
public	MoveNorth(MoveCommand m){
		this.m=m;
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		m.moveNorth();
		
	}

}
