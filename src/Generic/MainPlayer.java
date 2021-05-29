package Generic;
import Behaviours.*;
import Command.*;
import Items.BasicSword;
import Items.HealthPotion;

public class MainPlayer extends ConcreteSubject  implements Runnable, Observer {
//player -> Singleton pattern
	private static  MainPlayer instance;
	ConcreteSubject [] subjectsArr = null;
	boolean hitEnemy = false, dodgeEnemy = false, usePotion = false, commandReceived=false, createCommands = false;
	public int health,itemIndex, swordDamage = 0;
	int healthMax=3; //PLAYER BASE HEALTH
	BasicSword basicSword;
	Strategy s;
	public String treeName ="", swordName = "", swordEquipped = "";
	public String newAction, topic="", payload="";
	String [] instructions;
	String [] treeTypes = {"maple", "pine"};
	String [] swordTypes = {"Basic Sword", "Geralt Sword"};
	public int [] swordDamageTypes = {5, 10};
	public int locationIndex,treeIndex, swordIndex;
	Game g;
	
	//create object to be acted upon
	MoveCommand mcommand;
	
	//create the commands
	MoveNorth mNorth;
	
	MoveWest mWest ;
	MoveSouth mSouth;
	MoveEast mEast;
	TalkCommand talkCommand;
	UseCommand useCommand;
	ShakeCommand shakeCommand;
	LookCommand lookCommand;
	EquipCommand equipCommand;
	RiddleCommand riddleCommand;
	//create the panel
	Command [] cmds;//talk=4, use=5
	ControlPanel p;
	
	public HealthPotion h;
	
	public void createCommands()
	{
		g = Game.getInstance();
		mcommand = new MoveCommand(this,g);
		
		//create the commands
		mNorth = new MoveNorth(mcommand);
		mWest = new MoveWest(mcommand);
		mSouth = new MoveSouth(mcommand);
		mEast = new MoveEast(mcommand);
		talkCommand = new TalkCommand(this,g);
		useCommand = new UseCommand(this,g);
		shakeCommand = new ShakeCommand(this,g);
		lookCommand = new LookCommand(this,g);
		equipCommand = new EquipCommand(this,g);
		riddleCommand = new RiddleCommand(this,g);
		Command [] tempCom = {mNorth,mEast,mWest,mSouth,talkCommand,useCommand, shakeCommand, lookCommand, equipCommand, riddleCommand};
		cmds = tempCom;
		p = new ControlPanel(cmds);
		//System.out.println("DONEEE CREARITN GCOMMSOS");
		h = new HealthPotion();
		
	}
	
	private  MainPlayer(ConcreteSubject [] subjects)
	{
		//super();
		this.subjectsArr = subjects;
		for(int i=0; i<subjects.length;i++)
		{ 
			subjectsArr[i].registerObserver(this);
		}
		Thread t = new Thread(this);
		t.start();
		this.health =this.healthMax;
		String[] temp = { "north", "east", "west", "south" }; //north village, east forest, west castle
		instructions = temp;
		//g = Game.getInstance();
		//createCommands();
		
	}
	
	public static synchronized  MainPlayer getInstance (ConcreteSubject [] subjects)
	{
		if (instance == null)
		{
			//System.out.println("awdawdawdan");
			instance = new  MainPlayer (subjects);
		}
		return instance;
	}
	
	public static synchronized  MainPlayer getInstance ()
	{
		
		return instance;
	}
	public boolean restoreHealth() {
		if(health<healthMax) {
			health++;
			return true;
		}else {
			return false;
		}
	}
	
	
	/*public void setBasicSword(BasicSword b){
		this.basicSword=b;
	}*/
	
	
	public void unlockPath(int i)
	{
		g.enablePath[i] = true;
		g.locationList[i].cannotComeBack = true;
		System.out.println("\n" + g.locationList[i].locationName + " Path is Completed\n");
		
		/*if (i == 2) //castle location
		{
			System.out.println("\nMake sure to look around to *TAKE IN* the wonderness of the Castle :D\n");
		}*/
	}
	
	public void unlockAllPath()
	{
		for (int i =0; i < g.enablePath.length; i++)
		{
			g.enablePath[i] = true;
			g.locationList[i].cannotComeBack = true;
		}
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true)
		{
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if (health <= 0)
			{
				System.out.println("Game Over, You have Died");
				System.exit(2);
			}
			
			else if (hitEnemy)
			{
				Message m = new Message(this, "attack", "yes");
				publishMessage(m); //This will be sent to the miniboss so his health is reduced
				// have to continue implementation to make sure u are attacking a miniboss at that location
				hitEnemy = false;
			}
			
			else if (dodgeEnemy)
			{
				Message m = new Message(this, "dodge", payload);
				publishMessage(m);
				dodgeEnemy = false;
			}
			
			else if (usePotion)
			{
				try {
					Thread.sleep(400);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				h.use();
				// have to continue implementation here so the player uses the potion
				usePotion = false;
				
			}
			
			
			
			if(commandReceived) {
				
				switch(topic) {
				case "walk":
					p.buttonWasPressed(locationIndex); 
					
					//north=0, east=1,west=2, south=3
					break;
				case "talk":
					p.buttonWasPressed(4); 
					break;
				case "use":
					p.buttonWasPressed(5); 
					break;
				case "shake":
					p.buttonWasPressed(6);
					break;
				case "look":
					p.buttonWasPressed(7);
					break;
				case "equip":
					p.buttonWasPressed(8);
					break;
				case "riddle":
					p.buttonWasPressed(9);
					break;
				}
				commandReceived=false;
			}
		}
		
		
	}
	

	
	public String extractDirection(String ins) {
			String extractedName = ins.substring(ins.indexOf("walk ") + 5);
			return extractedName;
		}
	
	public String extractName(String ins) {
		String extractedName = ins.substring(ins.indexOf('o') + 2);
		return extractedName;
	}

	public String extractItemName(String ins) {
		String extractedName = ins.substring(ins.indexOf(' ') + 1);
		return extractedName;
	}
	
	public String extractSwordName(String ins) {
		String extractedName = ins.substring(ins.indexOf("equip ") + 6);
		return extractedName;
	}
	
	public int extractSwordIndex(String ins) {
		for (int i = 0; i < swordTypes.length; i++) {
			if (swordTypes[i].equalsIgnoreCase(ins)) {
				return i;
			}
		}
		return -1;
	}
	

	
	public String extractTreeName(String ins) {
		String extractedName = ins.substring(ins.indexOf("shake ") + 6);
		return extractedName;
		}
	
	public int extractTreeIndex(String ins) {
		for (int i = 0; i < treeTypes.length; i++) {
			if (treeTypes[i].equalsIgnoreCase(ins)) {
				return i;
			}
		}
		return -1;
	}
	


	
	
	public int Action(String input) {
		for (int i = 0; i < instructions.length; i++) {
			if (instructions[i].equalsIgnoreCase(input))
				return i;
		}
		return -1;
	}
	@Override
	public synchronized void update(Message m) {
		//System.out.println("");
		
		//System.out.println("recieevedddddd");
		
		if (m.topic.equalsIgnoreCase("attack"))
		{
			hitEnemy = true;
		}
		
		
		
		else if (m.topic.equalsIgnoreCase("dodge"))
		{
			dodgeEnemy = true;
			payload = m.payload;
		}
		
		else if (m.topic.equalsIgnoreCase("talking") )
		{
			usePotion = true;
		}
		
		else if (m.topic.equalsIgnoreCase("walk"))
		{
			topic = m.topic;
			 locationIndex=Action(extractDirection(m.payload));
			if(locationIndex==-1) {
				System.out.println("false location!\n");
			}
			else {
				commandReceived=true;
				}
			
		}
		else if (m.topic.equalsIgnoreCase("talk"))
		{
			topic = m.topic;
			 newAction=extractName(m.payload);
			if(!g.current.verifyCharacter(newAction)) {
				System.out.println("Character is not here!\n");
			}
			else {
			commandReceived=true;
			}
		}
		else if(m.topic.equalsIgnoreCase("shake")) {
			topic=m.topic;
			treeIndex= extractTreeIndex(extractTreeName(m.payload));
			if(treeIndex==-1) {
				System.out.println("No such tree!\n");
			}
			else {
				treeName= treeTypes[treeIndex].toLowerCase();
				commandReceived=true;
				}
		}
		
		else if(m.topic.equalsIgnoreCase("equip")) {
			topic=m.topic;
			swordIndex= extractSwordIndex(extractSwordName(m.payload));
			if(swordIndex==-1) {
				System.out.println("No such sword exists!\n");
			}
			else {
				swordName= swordTypes[swordIndex].toLowerCase();
				commandReceived=true;
				}
		}
		
		else if(m.topic.equalsIgnoreCase("use")) {
			topic=m.topic;
			newAction=extractItemName(m.payload);
			itemIndex=g.current.searchObject(newAction);
			if(itemIndex==-1) {
				System.out.println("No such item!\n");
			}
			else {
				commandReceived=true;
				}
		}
			
			else if(m.topic.equalsIgnoreCase("look")) {
				
				topic = m.topic;
				commandReceived = true;
			}
		
			else if(m.topic.equalsIgnoreCase("riddle")) {
				
					topic = m.topic;
					commandReceived = true;
				}
		
			else if (m.topic.equalsIgnoreCase("start"))
			{
				if(m.payload.equalsIgnoreCase("yes"))
				{	
					g.current.identifyLocation();
					g.locationList[0].cannotComeBack = true;
				}
				
				else { System.out.println("Incorrect Command... try again\n");}
			}
		
			else {
				commandReceived=true;
			}
				
		}
	}
	
	

