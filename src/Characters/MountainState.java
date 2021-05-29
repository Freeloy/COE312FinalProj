package Characters;

import Generic.State;

public class MountainState implements State {

	@Override
	public void prev(Context context) {
		//context.setState(new VillageState());

	}

	@Override
	public void next(Context context) {
		System.out.println("last state!");

	}

	@Override
	public void printStatus() {
		// TODO Auto-generated method stub

	}
}
