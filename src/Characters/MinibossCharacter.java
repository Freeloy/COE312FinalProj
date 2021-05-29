package Characters;

import java.util.Random;

import Generic.*;
import Items.HealthPotion;

public class MinibossCharacter extends Character implements Runnable,Observer {
int health ,lowest = 3,  highest = 5, cycles, location;
boolean gotHit = false, phaseDone = false, dodged = false;
HealthPotion h;
Thread t;
private Subject subject;
Random r = new Random();
int randBossAttack;
MainPlayer p;
//Game g;

	@Override
	public void talk() {
		System.out.println( name + ": YOU won't get out of here alive!");
		
	}
	public MinibossCharacter(String name, int health, Subject sub, int location)
	{
		super (name); //will change this to assign different name for each location
		this.health = health;
		this.subject = sub;
		subject.registerObserver(this);
		t = new Thread(this);
		p = MainPlayer.getInstance();
		//g = Game.getInstance();
		this.location = location;
	}

	
	public void run() {
	
			// TODO Auto-generated method stub
		while (health !=0)
		{
			
			if (!phaseDone)
			{
			randBossAttack = r.nextInt(highest-lowest)+lowest;
			cycles = randBossAttack;
			phaseDone = true;
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
			System.out.println("\n" + name + " is getting ready to attack (make sure to dodge).\n");
			dodged = false;
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if (dodged)
			{
				System.out.println(name + " missed his attack.\n\n");
			}
			
			else {
				p.health--;
				System.out.println("\nYou got HIT. Player Health remaining: " + p.health +"\n\n");
			}
			dodged = false;
			phaseDone = false;
			
		}
		
			if (gotHit)
			{
				health = health - p.swordDamage; // can be changed, just an example
				System.out.println(name + " got pierced by the sword. Health remaining:  " + health);
				gotHit = false;
				
				if (health == 0)
				{
					System.out.println("\n" + name + " has died. Please proceed to collect your loot");
					
					p.h.makeItem();
					
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					if (location == 2)
					{
						System.out.println("\nMake sure to Check on Prince Luigi and ensure that he is not harmed\n");
					}
					
					p.unlockPath(location); //completed location
					
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
				dodged = true;
			}
		}
		@Override
		public void startThread() {
			// TODO Auto-generated method stub
			t.start();
		}
}
