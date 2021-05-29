package Generic;

public class ConcreteObserver implements Observer{
	private Subject subject;
	ConcreteSubject [] subjects = null;
	public ConcreteObserver(Subject subject)
	{
	this.subject = subject;
	subject.registerObserver(this);
	}
	
	public ConcreteObserver(ConcreteSubject [] subjects){
		
		this.subjects = subjects;
		for(int i=0; i<subjects.length;i++)
		{ 
			subjects[i].registerObserver(this);
		}

		}


	@Override
	public void update(Message m) {
		// TODO Auto-generated method stub
		
	}
	
}

