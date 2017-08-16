package com.ahfdkun.service.mock;

/**
 * @Description:
 * 
 * @author: yakun.zhao
 * 
 * @date: 2017年8月16日 下午2:20:34
 */
public class MathApplication {
	private CalculatorService calcService;

	public double add(double input1, double input2) {
		calcService.serviceUsed();
		return calcService.add(input1, input2);
	}

	public double subtract(double input1, double input2) {
		return calcService.subtract(input1, input2);
	}

	public double multiply(double input1, double input2) {
		return calcService.multiply(input1, input2);
	}

	public double divide(double input1, double input2) {
		return calcService.divide(input1, input2);
	}
	
}
