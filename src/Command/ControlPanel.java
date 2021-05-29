package Command;

public class ControlPanel {
	Command [] slots;
	public ControlPanel(Command [] slots) {
	this.slots = slots;
	}
	public void buttonWasPressed(int index){
		if(index<slots.length) {
			slots[index].execute();
		}else {
			System.out.println("ERROR!Comman panel index is out of bounds");
		}
	
	
	}
}
