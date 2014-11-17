package merpeople.arduino;

public class SalinitySensorOld 
{
	//Constant Calculation Values
	private final static double C15= 4.2914;
	
	private final static double k = 0.0162;
	
	private final static double T = 25;
	
	private final static double P = 10.13;
	
	private final static double[] aArr = 
		{0.008, -0.1692, 25.3851, 14.0941, -7.0261, 2.7081};
	
	private final static double[] bArr = 
		{0.0005, -0.0056, -0.0066, -0.0375, 0.0636, -0.0144};
	
	private final static double[] cArr = 
		{0.6766097, 2.00564e-2, 1.104259e-4, -6.9698e-7, 1.0031e-9};
	
	private final static double[] dArr = 
		{3.426e-2, 4.464e-4, 4.215e-1, -3.107e-3};
	
	private final static double[] eArr = 
		{2.07e-5, -6.37e-10, 3.989e-15};
	
	//PrivateConstructor
	private SalinitySensorOld(){}
	
	//Salinity Calculations
	public static double calculateSalinity(double C)
	{
		double R = C / C15;
		
		double rt = cArr[0] + (cArr[1] + (cArr[2] + (cArr[3] + cArr[4] * T) * T) * T) * T;
		
		double Rp = 1.0 + (eArr[0] + (eArr[1] + eArr[2] * P) * P) * P / 
				(1.0 + (dArr[0] + dArr[1] * T) * T + (dArr[2] + dArr[3] * T) * R);
		
		double Rt = R / Rp / rt;
		
		double sqrt_Rt = Math.sqrt(Rt);
		
		double Salt = aArr[0] + (aArr[1] + (aArr[3] + aArr[5] * Rt) * Rt) * sqrt_Rt + (aArr[2] + aArr[4] * Rt) * Rt;

		double dS = bArr[0] + (bArr[1] + (bArr[3] + bArr[5] * Rt) * Rt) * sqrt_Rt + (bArr[2] + bArr[4] * Rt) * Rt;
		
		dS = dS * (T - 15) / (1 + k * (T - 15));

		return (Salt + dS);
	}
}
