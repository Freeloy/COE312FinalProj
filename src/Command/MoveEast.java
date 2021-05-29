package Command;


public class MoveEast implements Command {
	MoveCommand m;
public	MoveEast(MoveCommand m){
		this.m=m;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		m.moveEast();
		
	}

}
