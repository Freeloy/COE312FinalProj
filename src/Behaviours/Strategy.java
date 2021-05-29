package Behaviours;

import Characters.*;
import Generic.*;

public abstract class Strategy {
	FinalBoss Drag;
	MainPlayer p;
	public String dodgeMethod;
	
	public Strategy(FinalBoss Drag, MainPlayer p) {
	
		this.Drag = Drag;
		this.p = p;
	}
	
	public abstract void attackMethod();
	public abstract void attackHit();
	public abstract void attackMiss();

}
