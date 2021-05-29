package Characters;

import java.util.Random;

import Behaviours.*;
import Generic.MainPlayer;
import Generic.Message;
import Generic.Observer;
import Generic.Subject;
import Items.HealthPotion;

public class FinalBoss extends Character implements Runnable,Observer{
	int health, maxHealth, lowest = 3,  highest = 5, cycles;
	boolean gotHit = false, phaseDone = false, dodged = false;
	HealthPotion h;
	Thread t;
	private Subject subject;
	Random r = new Random();
	int randBossAttack;
	MainPlayer p;
	Strategy strategy;
	String payload;
	
	public FinalBoss(String name, int health, Subject sub)
	{
		super (name); //will change this to assign different name for each location
		this.health = health;
		t = new Thread(this);
		this.subject = sub;
		subject.registerObserver(this);
		p = MainPlayer.getInstance();
		maxHealth = health;
		strategy = new NormalStrategy(this, p);
	}

	@Override
	public void talk() {
		
		
	}
	public void run() {
		// TODO Auto-generated method stub
		while (health != 0)
		{
			if (!phaseDone)
			{
			randBossAttack = r.nextInt(highest-lowest)+lowest;
			cycles = randBossAttack;
			phaseDone = true;
			}
			
			if (health == maxHealth/5)
			{
				strategy = new EnragedStrategy(this, p);
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
		try {
			Thread.sleep(1000);
			cycles --;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		if (cycles==0)
		{
			strategy.attackMethod();
			//System.out.println(name + "is getting ready to attack using Whiplash(make sure to dodge).\n");
			dodged = false; //resets input if you tried to dodge before the attack
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if (dodged && strategy.dodgeMethod.equalsIgnoreCase(payload))
			{
				strategy.attackMiss();
				//System.out.println(name + " missed his attack.\n");
			}
			
			else {
				strategy.attackHit();
				//p.health = p.health-2;
				//System.out.println("You got HIT. Player Health remaining: " + p.health +"\n");
			}
			
			dodged = false;
			phaseDone = false;
			
		}
			
			
		if (gotHit)
		{
			health = health - p.swordDamage; // can be changed, just an example
			System.out.println(name + " got pierced by the sword. Enemy Health remaining:  " + health +"\n");
			gotHit = false;
			
			if (health == 0)
			{
				System.out.println(name + " HAS DIED.\n");
				System.out.println("\nYOU HAVE DONE IT!! YOU SAVED THE GREAT KINGDOM OF NOKDU\n"
						+ "You have PROVED that you are a worthy warrior and we hope\n"
						+ "that you can help us anytime we face a threat\n"
						+ "\nThank you for Playing this game, we hope you enjoyed it!\n");
				System.exit(2);
			}
			
		}
		
		
		}
		
	}

	@Override
	public void update(Message m) {
		// TODO Auto-generated method stub
		if (m.topic == "attack")
		{
			gotHit = true;
		}
		
		else if (m.topic == "dodge")
		{
			payload = m.payload;
			dodged = true;
		}
	}
	@Override
	public void startThread() {
		// TODO Auto-generated method stub
		t.start();
	}
}


