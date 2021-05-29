package Characters;

public abstract class Character {
	public abstract void talk();
	public String name;
	public boolean personTalked;
	Character()
	{
		name = "unknown";
	} 
	Character(String aname)
	{
		name = aname; 
	}

public abstract void startThread();

}
