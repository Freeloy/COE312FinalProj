package Scenes;
import Characters.Character;
import Characters.Context;
import Items.BasicSword;
import Items.Item;

abstract public class Scene {
	
	public String locationName;
	public Character person;
	public Character enemy;
	public String description;
	public Item[] objectlist;
	public Context con;
public boolean playerIsHere=false;
public boolean canUseItem=false;
public boolean cannotComeBack=false;
	Scene() {

	}
	

	Scene(String des, Character aperson, Item[] obj) {
		description = des;
		person = aperson;
		objectlist = obj;
	}
	public int searchObject(String objname) {
		for (int i = 0; i < objectlist.length; i++) {
			if (objname.equalsIgnoreCase(objectlist[i].name))
				return i;
		}
		return -1;
	}

	public boolean verifyCharacter(String aname) {
		if (person.name.equalsIgnoreCase(aname)) {
			return true;
		}
		
		else if (enemy.name.equalsIgnoreCase(aname)) {
			return true;
		}

		else
			return false;
	}
public abstract void identifyLocation();
//public abstract void talkToMiniBoss();
//public abstract void  fightMiniBoss(BasicSword b);
public abstract void  useObject();
}
