package merpeople.arduino;

public final class SalinitySensor 
{
	private static double SALINITY_CONSTANT;
	private final static double CALIBRATION_SALINITY = 13.54;
	
	private SalinitySensor(){}
	
	public static double calculateSalinity(double conductivity)
	{
		return (conductivity * SALINITY_CONSTANT);
	}
	
	public static double calibrateOld(double conductivity)
	{
		SALINITY_CONSTANT = (conductivity/CALIBRATION_SALINITY);
		
		return SALINITY_CONSTANT;
	}
}
