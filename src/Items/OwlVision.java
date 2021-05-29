package Items;

public class OwlVision extends  Item{

	public OwlVision() {
		super("Owl vision");
		
	}



	@Override
	
	public void acquire() {
	
		System.out.println("\nAcquiring Owl vision item..");
		
	}

	

	@Override
	
	
	public void use() {
		System.out.println("\nActivating owl vision.");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Increasing Depth Perception 100x");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("----------> *ACTIVATED* ");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("You can clearly see the Dragon sleeping on his pile of Gold in an Elevated Area (location still unknown).\n");
		
	}



	@Override
	
	public void complete() {
		// TODO Auto-generated method stub
		System.out.println("Picked up Owl Vision item..\n");
	}

}

