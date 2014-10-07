package merpeople.arduino;

import rxtxrobot.*;

public class ArduinoMain 
{
	final static int BUMP_SENSOR = 1; //A1
	final static int INFRARED_SENSOR = 0; //A0
	final static int TURBIDITY_SENSOR = 4; //A4
	final static int SALINITY_SENSOR = 5; //A5
	
	final static int ARM_SERVO = 0; //D7
	final static int TRAPDOOR_SERVO = 0; //D8
	
	final static int LEFT_MOTOR = RXTXRobot.MOTOR1; 
	final static int RIGHT_MOTOR = RXTXRobot.MOTOR2; 
	
	//D2 - Left Motor Encoder
	//D3 - Right Motor Encoder
	//D5 - Left Motor Controller
	//D6 - Right Motor Controller
	
	static RXTXRobot r = new ArduinoNano();
		
	public static void main(String[] args) 
	{
		r.setPort("COM5");
		r.setVerbose(true);
		r.connect();
		
		//BODY SHIT
		
		r.close();
	}
}
