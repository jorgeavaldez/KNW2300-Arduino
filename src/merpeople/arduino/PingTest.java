package merpeople.arduino;

import rxtxrobot.ArduinoNano;
import rxtxrobot.RXTXRobot;

public class PingTest 
{
	static RXTXRobot r = new ArduinoNano();
	
	public static void main(String[] args) 
	{
		r.setPort("COM5");
		r.setVerbose(true);
		
		r.connect();
		
		r.refreshAnalogPins();
		
		for (int i = 0; i < 25; i++)
		{
			System.out.println(r.getPing(7));
		}
	}

}
