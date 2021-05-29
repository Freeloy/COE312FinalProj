package Generic;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.io.BufferedReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class TCP extends ConcreteSubject implements Runnable {

	// ip address of the machine
	String host = "172.27.21.239";

	// need the port
	int port = 8080;

	Integer directionValue;
	int triggerLimit = -20;
	Double power;

	TCP(String host, int port) {

		// set the ip address and the port of the
		// the server we will connect to.

		this.host = host;
		this.port = port;

		// make this a thread
		Thread t = new Thread(this);
		t.start();
	}

	public void run() {

		try {

			// create an instance of the Socket
			// try to create a socket connection to
			// host using port

			// block -- the program will wait here \
			// to form a connection.
			// if somthing goes wrong, the progrma will
			// create an exception

			Socket socket = new Socket(host, port);

			// returns a socket object

			// grab the input stream so I can read the sensors

			InputStream input = socket.getInputStream();
			InputStreamReader reader = new InputStreamReader(input);

			BufferedReader br = new BufferedReader(reader);
			JSONParser parser = new JSONParser();
			String line = "";
			while ((line = br.readLine()) != null) {
				// System.out.print(line);
				JSONObject jsonObj = (JSONObject) parser.parse(line);
				String accx = (String) jsonObj.get("accelerometerAccelerationX");
				String audio = (String) jsonObj.get("avAudioRecorderAveragePower");
				Double ax = Double.parseDouble(accx);
				Double power = Double.parseDouble(audio);
				String direction = (String) jsonObj.get("deviceOrientation");
				
				//System.out.println(power);
				
				
				directionValue = Integer.parseInt(direction);
				if (directionValue == 5) {
					Message m = new Message(this, "dodge", "jump");		
					publishMessage (m);
						} 
				
				else if (directionValue == 6) {
					Message m = new Message(this, "dodge", "down");		
					publishMessage (m);
						} 
				
				
				if (ax > 0.5 || ax <-0.5)
				{
					Message m = new Message(this, "attack", "yes");
					publishMessage (m);
				}
				
				
				if (power > triggerLimit)
				{
					Message mm = new Message(this, "talking", "yes");
					publishMessage (mm);
				}

				
				

			}

			// to read and print data

			// int character;

			// while ((character = reader.read()) != -1) {

			// System.out.print((char) character); }

		} catch (UnknownHostException ex) {

			System.out.println("Server not found: " + ex.getMessage());

		} catch (IOException ex) {

			System.out.println("I/O error: " + ex.getMessage());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}


