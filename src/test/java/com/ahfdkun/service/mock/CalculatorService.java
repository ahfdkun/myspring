package com.ahfdkun.service.mock;

/**
 * @Description:
 * 
 * @author: yakun.zhao
 * 
 * @date: 2017年8月16日 下午2:20:09
 */
public interface CalculatorService {
	
	public double add(double input1, double input2);

	public double subtract(double input1, double input2);

	public double multiply(double input1, double input2);

	public double divide(double input1, double input2);
	
	public void serviceUsed();
}
