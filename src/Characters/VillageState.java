package Characters;

import Generic.State;

public class VillageState implements State {

	@Override
	public void prev(Context context) {
		System.out.println("This state is the initial state!");

	}

	@Override
	public void next(Context context) {
		context.setState(new MountainState());
		context.inMountain=true;
		context.inVillage=false;

	}

	@Override
	public void printStatus() {
		// TODO Auto-generated method stub
	}

}

