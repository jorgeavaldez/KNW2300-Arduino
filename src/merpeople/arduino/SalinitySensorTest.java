package merpeople.arduino;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import rxtxrobot.ArduinoNano;
import rxtxrobot.RXTXRobot;

public class SalinitySensorTest 
{
	//Analog Sensors
	final static int TURBIDITY_OUT = 2;
	final static int SALINITY_1 = 4;
	final static int SALINITY_2 = 5;
	
	//Digital Sensors
	
	final static int PING_SENSOR = 11;
	
	//Left Motor
	final static int MOTOR_ENCODER_1 = 2;
	final static int MOTOR_CONTROLLER_1 = 5;
	
	//Right Motor
	final static int MOTOR_ENCODER_2 = 3;
	final static int MOTOR_CONTROLLER_2 = 6;
	
	final static int SERVO_BALL_ARM = 7;
	final static int SERVO_BALL_RELEASE = 8;
	final static int SERVO_SENSOR_ARM = 9;
	
	final static int SALINITY_SENSOR_1 = 12;
	final static int SALINITY_SENSOR_2 = 13;
	
	final static int STANDARD_SPEED = 250;
	
	final static double SALINITY_CONSTANT = 0.9601181683899558;
	
	static RXTXRobot robot = new ArduinoNano();
	
	public static void main(String[] args) throws Exception
	{
		robot.setPort("COM5");
		robot.setVerbose(true);
		robot.connect();
		
		robot.attachServo(RXTXRobot.SERVO1, SERVO_BALL_ARM);
		robot.attachServo(RXTXRobot.SERVO2, SERVO_BALL_RELEASE);
		robot.attachServo(RXTXRobot.SERVO3, SERVO_SENSOR_ARM);
		
		robot.refreshAnalogPins();
		robot.refreshDigitalPins();
		
		double roundedSalinity = 0;
		
		calibrateSalinitySensor(roundedSalinity);

	}
	
	public static void calibrateSalinitySensor(double salinity) throws FileNotFoundException, UnsupportedEncodingException
	{		
		PrintWriter writer = new PrintWriter("C:\\Users\\Jorge\\Google Drive\\College\\Classes\\KNW 2300\\Water Testing and Remediating Robot\\" 
											+ (int)(Math.round(salinity)) + ".txt", "UTF-8");
		
		System.out.println("TESTING CONDUCTIVITY");
		System.out.print("TESTING IN ");
		
		try
		{
			Thread.sleep(1000);
			System.out.println("3");
			Thread.sleep(1000);
			System.out.println("2");
			Thread.sleep(1000);
			System.out.println("1");
		
			for (int i = 0; i < 20; i++)
			{
				double conductivity = robot.getConductivity();
				
				writer.println("SENSOR VALUE " + i + ": " + conductivity);
				System.out.println("SENSOR VALUE " + i + ": " + conductivity);
				
				Thread.sleep(1000);
			}
		}
		
		catch(InterruptedException e)
		{
			Thread.currentThread().interrupt();
		}
		
		System.out.println("CALIBRATION COMPLETE :D");
		writer.close();
	}
}
