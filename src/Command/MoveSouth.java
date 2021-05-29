package Command;



public class MoveSouth implements Command {
	MoveCommand m;
	public MoveSouth(MoveCommand m){
		this.m=m;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		m.moveSouth();
		
	}

}
