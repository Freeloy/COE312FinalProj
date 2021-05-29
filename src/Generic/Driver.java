package Generic;

public class Driver {
	
	public static void main(String[] args) {
		
		UI ui = UI.getInstance(System.in);
		TCP tcp = new TCP("192.168.2.120", 59862);
		//Game g = Game.getInstance();
		ConcreteSubject [] playerSubjects = {tcp, ui}; //Have to finish ui
		//MainPlayer p1 = MainPlayer.getInstance(playerSubjects);
		Game g = Game.getInstance(playerSubjects);
		//ConcreteSubject [] gameSubjects = {p1};
		//Game g = Game.getInstance(gameSubjects);
		
		System.out.print("The Objective of this game is to save the Great Kingdom of Nokdu from the threats it faces."
				+ "\nYou will have to clear all available paths to reach the final destination and save everyone."
				+ "\nIf you think you got what it takes, enter EASY...\nIf you give up at anytime, enter EXIT..\n\n");
		
		//System.out.print(" Welcome to the village adventurer...\n");
		/*MainPlayer p1;
		BufferedReader userinput;
		String endgame = "i give up"; 
		public UserInterface(BufferedInputStream input) {
			this.userinput = input;
			this.p1 = MainPlayer.getInstance();
			Thread t = new Thread(this);
			t.start();
			// TODO Auto-generated constructor stub
		}
	}*/

	
	
	}
}
