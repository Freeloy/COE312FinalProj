package Behaviours;

import Characters.*;
import Generic.*;


public class NormalStrategy extends Strategy {

	public NormalStrategy(FinalBoss Drag, MainPlayer p) {
		super(Drag,p);
		dodgeMethod = "jump"; //phone orientation upwards
		// TODO Auto-generated constructor stub
	}

	@Override
	public void attackMethod() {
		// TODO Auto-generated method stub
		System.out.println("\n"+ Drag.name + "is getting ready to attack using Whiplash(make sure to dodge by jumping).\n");
	}

	@Override
	public void attackHit() {
		// TODO Auto-generated method stub
		p.health = p.health-2;
		if (p.health <= 0)
		{
			p.health = 0;
		}
		System.out.println("\nYou got HIT by the WhipLash. Player Health remaining: " + p.health +"\n\n");
		
		
	}

	@Override
	public void attackMiss() {
		// TODO Auto-generated method stub
		System.out.println(Drag.name + " missed his attack and his Gold Treasure hoard.\n\n");
	}

}
