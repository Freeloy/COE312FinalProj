package Characters;

import Generic.State;

public class Context {
	public boolean inVillage=true;
	Character G = new GeraltCharacter();
	boolean inMountain=false;
	private State state = new VillageState();

	public void previousState() {
	state.prev(this);
	}
	public void nextState() {
	state.next(this);
	}
	public void printStatus() {
	state.printStatus();
	}
	public void setState(State state) {
	this.state = state;
	}
	
	}



