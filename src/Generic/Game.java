package Generic;

import Characters.Context;
import Items.BasicSword;
import Scenes.*;


public class Game  implements Runnable{ //observes ui if u quit and player if he dies

	public MainPlayer p1;
	public	Scene current;
	Message m;
	public Scene[] locationList; 
	public VillageScene vs;
	public ForestScene fs;
	public CastleScene cs;
	public MountainScene ms;
	private static Game instance;
	public boolean activate = false, allPathsUnlocked = false;
	public Context GeraltState = new Context();
	public Watch w = new Watch();
	public boolean constructionIsDone = false;
	BasicSword b;
	
	
	public boolean [] enablePath= {true,false,false}; //start in village
	
	public void setAll() {
		enablePath[0]=true;
		enablePath[1]=true;
		enablePath[2]=true;
	}
	
	
	public boolean MountainPathUnlocked()
	{
		for (int i =0; i<2; i++)
		{
			if (enablePath[i] == false)
			{
				return false;
			}
		}
		
		return true;
	}
	
	
	
	public static synchronized  Game getInstance (ConcreteSubject [] subjects)
	{
		if (instance == null)
		{
			instance = new  Game(subjects);
		}
		return instance;
	}
	public static synchronized  Game getInstance ()
	{
		
		return instance;
	}
	
	private Game(ConcreteSubject [] subjects )
	{
		//super(subjects);
		this.p1 = MainPlayer.getInstance(subjects);
		b = new BasicSword();
		 vs = new VillageScene(GeraltState, b);
		 fs = new ForestScene();
		 cs = new CastleScene(b);
		 ms = new MountainScene(w, w);//to control watch thread and to register it
		 
		 Scene[] temp = {vs, fs, cs, ms }; //add more
		locationList=temp;
		current = locationList[0];
		Thread t = new Thread(this);
		t.start();
		constructionIsDone = true;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		while (true)
		{
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if (constructionIsDone)
			{
				p1.createCommands();
				constructionIsDone = false;
			}
			
			else if( !allPathsUnlocked && enablePath[0] && enablePath[1] && enablePath[2])
			{
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("\n       You have Proved yourself, The path South will lead you to your final destination.\n");
				allPathsUnlocked = true;
		
			}
			/*if (activate)
			{
		if (m.topic.equalsIgnoreCase("quit"))
		{
			System.out.println("You quit, what a loser");
			System.exit(2);
			
		}
			}
		
		/*else if (m.topic.equalsIgnoreCase("died"))
		{
			System.out.println("You died, try again");
			System.exit(2);
		}*/
		//}
		
	//}
	
	//public synchronized void update(Message m) {
	//activate = true;
		
		}
	
	}
}
