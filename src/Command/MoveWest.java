package Command;



public class MoveWest implements Command {
MoveCommand m;
public MoveWest(MoveCommand m){
	this.m=m;
}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		m.moveWest();
	}

}
