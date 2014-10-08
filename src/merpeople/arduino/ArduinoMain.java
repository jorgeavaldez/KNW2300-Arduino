package merpeople.arduino;

import rxtxrobot.*;

public class ArduinoMain 
{
	final static int BUMP_SENSOR = 1; //A1
	final static int INFRARED_SENSOR = 12; //A0
	final static int TURBIDITY_SENSOR = 4; //A4
	final static int SALINITY_SENSOR = 5; //A5
	
	final static int ARM_SERVO = 7; //D7
	final static int TRAPDOOR_SERVO = 8; //D8
	
	final static int LEFT_MOTOR = RXTXRobot.MOTOR1; 
	final static int RIGHT_MOTOR = RXTXRobot.MOTOR2; 
	
	final static int SERVO_HOME = 0;
	
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
		
		r.attachServo(RXTXRobot.SERVO1, ARM_SERVO); //Connect the servo to the Arduino 
		
		//Move forward for 3 meters
		//demo3MeterRun();
		
		//r.sleep(3000);
		
		//Run for 500 ticks
		//demo500TickRun();
		
		//Run until bump
		//demoMoveUntilBump();
		
		//r.sleep(3000);
		
		//Move servo to an angle
		//demoServoMovement(45);
		
		//r.sleep(3000);
		
		//Infrared Sensing
		//demoDistanceReading();
		
		//r.sleep(3000);
		
		//demoBumpSensor();
		
		r.close();
	}
	
	public static void demo3MeterRun()
	{
		r.runMotor(RXTXRobot.MOTOR1, 500, 3350);
	}
	
	public static void demo500TickRun()
	{
		r.runEncodedMotor(RXTXRobot.MOTOR1, 500, 500);
	}
	
	//TODO: Fix move until bump.
	public static void demoMoveUntilBump()
	{
		r.refreshAnalogPins();
		
		while(r.getAnalogPin(BUMP_SENSOR).getValue() <= 500)
		{
			r.runMotor(RXTXRobot.MOTOR1, 500, 1);
		}
			
		r.runMotor(RXTXRobot.MOTOR1, 0, 0);
	}
	
	public static void demoServoMovement(int angle)
	{
		r.moveServo(RXTXRobot.SERVO1, SERVO_HOME); // Move Servo 1 to home
		r.sleep(3000);
		r.moveServo(RXTXRobot.SERVO1, angle);
		r.sleep(3000);
		r.moveServo(RXTXRobot.SERVO1, SERVO_HOME);
	}
	
	//TODO: Fix distance reading with new sensor.
	public static void demoDistanceReading()
	{	
		r.refreshDigitalPins();
		System.out.println("DISTANCE: " + r.getPing(INFRARED_SENSOR));
	}
	
	public static void demoBumpSensor()
	{
		r.refreshAnalogPins();
		System.out.println("BUMP: " + r.getAnalogPin(BUMP_SENSOR).getValue());
	}
}
