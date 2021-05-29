package Command;

import Generic.*;

public class EquipCommand implements Command {
	MainPlayer player;
	Game g;
public EquipCommand(MainPlayer player, Game g) {
	this.player=player;
	this.g=g;
}
	@Override
	public void execute() {
		if(player.swordName.equalsIgnoreCase("Geralt sword") && !g.locationList[3].canUseItem ) {
			System.out.println("\nSword not owned, Unable to equip\n");
		}
		
		else if (player.swordEquipped.equals(""))
		{
			player.swordEquipped = player.swordName;
			player.swordDamage = player.swordDamageTypes[0];
			System.out.println("\nEquipping Basic Sword... (5 Damage per hit).\n");
		}
		
		else if (player.swordName.equalsIgnoreCase(player.swordEquipped))
		{
			System.out.println("\n"+ player.swordName + " is already Equipped...\n");
		}
		
		else 
		{
			player.swordEquipped = player.swordName;
			player.swordDamage = player.swordDamageTypes[player.swordIndex];
			System.out.println("\nEquipping "+ player.swordName + "... ("+player.swordDamage+" Damage per hit).\n");
		}
		
		
	}

}
