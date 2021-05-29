package Generic;

public class Watch extends ConcreteSubject implements Runnable{
	
	public Thread t;
	public int time =0;

	public Watch()
	{
		 t = new Thread(this);
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true)
		{
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		time = time+1;
		
		if (time == 10)
		{
			publishMessage( new Message(this, "timedone", "10 seconds"));
		}
		
		}
	}
}
