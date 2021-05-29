package Characters;

public class PrinceCharacter extends Character {
	public PrinceCharacter()
	{
		super ("Prince Luigi");
		personTalked = false;
	}

	@Override
	public void talk() {
		System.out.println("\nPrince Luigi: THANK YOU FOR SAVING ME, as a reward i will tell you a *secret*.\n"
				+ "              The palace has a very valuable item in it, To get it you have to solve this Riddle.\n"
				+ "              Otherwise you can continue your journey.\n"
				+ "              if you want try it out make sure to type RIDDLE.\n");
		personTalked = true;
	}

	@Override
	public void startThread() {
		// TODO Auto-generated method stub
		
	}
}

