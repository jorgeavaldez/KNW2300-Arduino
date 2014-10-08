package merpeople.arduino;

import rxtxrobot.*;

public class ArduinoMain 
{
	final static int BUMP_SENSOR = 1; //A1
	final static int INFRARED_SENSOR = 0; //A0
	final static int TURBIDITY_SENSOR = 4; //A4
	final static int SALINITY_SENSOR = 5; //A5
	
	final static int ARM_SERVO = 7; //D7
	final static int TRAPDOOR_SERVO = 8; //D8
	
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
		
		//Bullet 1
		//Move forward for 90 Ticks
		//Using it to measure how much 1 rotation gives us, and then determining how many ticks are 3 meters
		r.runEncodedMotor(RXTXRobot.MOTOR1, 255, 90, RXTXRobot.MOTOR2, 255, 90);
		
		r.attachServo(RXTXRobot.SERVO1, ARM_SERVO); //Connect the servos to the Arduino 
		r.moveServo(RXTXRobot.SERVO1, 0);
		
		/*
		//Bullet 2
		//Run for 500 ticks
		r.runEncodedMotor(RXTXRobot.MOTOR1, -255, 500, RXTXRobot.MOTOR2, 255, 500);
		
		//Bullet 3
		//
		r.attachServo(RXTXRobot.SERVO1, ARM_SERVO); //Connect the servos to the Arduino 
		
		r.moveServo(RXTXRobot.SERVO1, 0); // Move
		Servo 1 to location 0
		r.moveServo(RXTXRobot.SERVO1, 90); // Move Servo 1 to location 90
		r.moveServo(RXTXRobot.SERVO1, 180); // Move Servo 2 to location 180
		*/
		
		r.close();
	}
}
