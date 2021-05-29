package Behaviours;

import Characters.*;
import Generic.*;


public class EnragedStrategy extends Strategy{

	public EnragedStrategy(FinalBoss Drag, MainPlayer p) {
		super(Drag, p);
		dodgeMethod = "down"; //phone orientation upwards
		System.out.println("\n"+Drag.name + "is ENRAGED now and is Flying.\n"
				+ Drag.name + "will attack From the Sky using its Fire Breath (make sure to dodge).\n"
						+ "BEWARE, You won't Survive the Fire Breath\n");
		// TODO Auto-generated constructor stub
	}


	@Override
	public void attackMethod() {
		// TODO Auto-generated method stub
		System.out.println("\n"+ Drag.name + "is getting ready to attack using his Fire Breath (make sure to dodge by laying down).\n");
	}


	@Override
	public void attackHit() {
		// TODO Auto-generated method stub
		p.health = p.health-3;
		if (p.health <= 0)
		{
			p.health = 0;
		}
		System.out.println("\nYou got HIT by the FireBreath. Got Burnt into a Crisp. Player Health remaining: " + p.health +"\n\n");
	}


	@Override
	public void attackMiss() {
		// TODO Auto-generated method stub
		System.out.println(Drag.name + " missed his attack and burn the trees behind you.\n\n");
		
	}

}

	

