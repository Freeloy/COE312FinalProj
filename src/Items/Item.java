package Items;
import Generic.MainPlayer;

public abstract class Item {
	//to use item we need the audio sensor
	MainPlayer player;
	
	public String name;
	public Item(String name){
		this.name=name;
		this.player=MainPlayer.getInstance();
		//makeItem();
	}
	
	int countPotion=0;
	
final public void makeItem() {
	acquire();
	prepare();
	complete();//prints details of item
}
protected abstract void acquire(); //acquire item such as; owl vision, health potion, magic mirror, sword. 
protected void prepare() {
	System.out.println("In process..");
	
}
public abstract void complete();
public abstract void use();
}

