package merpeople.arduino;

import rxtxrobot.*;
import merpeople.arduino.SalinitySensor;

public class Sprint2CodeDemo 
{
	final static int BUMP_SENSOR = 1; //A1
	final static int INFRARED_SENSOR = 13; //D13
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
		
		r.refreshAnalogPins();
		
		for (int i = 0; i < 100; i++)
			System.out.println(r.getPing(7));
		
		r.attachServo(RXTXRobot.SERVO1, ARM_SERVO); //Connect the servo to the Arduino 
		
		//r.sleep(5000);
		
		//Move forward for 3 meters
		//demo3MeterRun();
		
		//r.sleep(5000);
		
		//Run for 500 ticks
		demo500TickRun();
		
		//r.sleep(5000);
		
		//Move servo to an angle
		//demoServoMovement(140);
		
		//r.sleep(5000);
		
		//Run until bump
		//r.runEncodedMotor(RXTXRobot.MOTOR1, 500, 5000);
		
		//r.sleep(5000);
		
		//Move servo to an angle
		//demoServoMovement(45);
		
		//r.sleep(3000);
		
		//TODO - AVERAGE READINGS
		//Distance Sensing
		//demoDistanceReading();
		
		//r.sleep(5000);
		
		//demoBumpSensor();
		
		r.close();
	}
	
	public static void demo3MeterRun()
	{
		//r.runMotor(RXTXRobot.MOTOR1, 500, 3350);
		
		r.runMotor(RXTXRobot.MOTOR1, 500, 3350);
		r.runMotor(RXTXRobot.MOTOR2, -500, 3350);
	}
	
	public static void demo500TickRun()
	{
		//r.refreshAnalogPins();
		
		while (r.getPing(7) > 40)
		{
			r.runMotor(RXTXRobot.MOTOR1, 250, RXTXRobot.MOTOR2, -250, 0);
		}
		
		r.runMotor(RXTXRobot.MOTOR1,0,RXTXRobot.MOTOR2,0,0);
		
		//r.runMotor(RXTXRobot.MOTOR1, 250, RXTXRobot.MOTOR2, -250, 10000);
		
		//r.runEncodedMotor(RXTXRobot.MOTOR2, 500, 100);
	}
	
	//TODO: Fix move until bump.
	public static void demoMoveUntilBump()
	{		
		r.refreshAnalogPins();
			
		r.runMotor(RXTXRobot.MOTOR1, 500, 0);
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
		r.refreshDigitalPins();
		for (int i = 0; i < 50; i++)
			System.out.println("BUMP: " + r.getDigitalPin(12).getValue());
	}
}
