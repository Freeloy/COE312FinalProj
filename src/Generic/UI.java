package Generic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class UI extends ConcreteSubject implements Runnable {
	MainPlayer p1;
	String action, readTemp;
	Message m;
	BufferedReader userinput;
	boolean startGame = false;
	public boolean inUse = false;
	private static UI instance;
	
	private UI(InputStream input) {
		this.userinput = new BufferedReader(new InputStreamReader(input));
		this.p1 = MainPlayer.getInstance();
		Thread t = new Thread(this);
		t.start();
		// TODO Auto-generated constructor stub
	}
	//To take other types of inputs
	private UI(BufferedReader input)
	{
		userinput = input;
		this.p1 = MainPlayer.getInstance();
		Thread t = new Thread(this);
		t.start();
	}

	private UI(InputStreamReader input)
	{
		this.userinput = new BufferedReader(input);
		this.p1 = MainPlayer.getInstance();
		Thread t = new Thread(this);
		t.start();
	}
	
	public static synchronized  UI getInstance(InputStream input)
	{
		if (instance == null)
		{
			instance = new  UI (input);
		}
		return instance;
	}
	
	public static synchronized  UI getInstance(BufferedReader input)
	{
		if (instance == null)
		{
			instance = new  UI (input);
		}
		return instance;
	}
	
	public static synchronized  UI getInstance(InputStreamReader input)
	{
		if (instance == null)
		{
			instance = new  UI (input);
		}
		return instance;
	}
	
	public static synchronized  UI getInstance ()
	{
		
		return instance;
	}
	
	
	public synchronized String readLine()
	{
		inUse = true;
		try {
			readTemp = userinput.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//inuse = false;
		return readTemp;
	}
	
	public void run() {
		
		
		while (true)
		{
			try {
				action = userinput.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(!startGame)
			{
				if (action.equalsIgnoreCase("easy")) {
				startGame = true;
				m = new Message(this, "start", "yes");
					}
				else { 
					m = new Message(this, "start", "no");
				}
				publishMessage(m);
			}
			
			else if (action.equalsIgnoreCase("look around")) {
				m = new Message(this, "look", action);
				publishMessage(m);
				}
			
			else if (action.contains("talk to")) {
				m = new Message(this, "talk", action);
				publishMessage(m);
				
				}
			
			else if (action.contains("walk")) {
				m = new Message(this, "walk", action);
				publishMessage(m);
				}
			
			else if (action.contains("use")) {
				
				m = new Message(this, "use", action);
				publishMessage(m);
				
				}
			else if (action.contains("shake")) {
					
					m = new Message(this, "shake", action);
					publishMessage(m);
					
					}
			else if (action.contains("equip")) {
				m = new Message(this, "equip", action);
				publishMessage(m);
			}
			
			else if (action.equalsIgnoreCase("riddle")) {
				m = new Message(this, "riddle", action);
				publishMessage(m);
				}
			
				else if (action.contains("exit")) {
					System.exit(2);
				}
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			while(inUse)
			{
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		}


	}
}