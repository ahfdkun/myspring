package com.ahfdkun.service.mock.test;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.MockType;
import org.easymock.TestSubject;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.ahfdkun.service.mock.CalculatorService;
import com.ahfdkun.service.mock.MathApplication;

/**
 * @Description:
 * 
 * @author: yakun.zhao
 * 
 * @date: 2017年8月16日 下午2:33:45
 */
@RunWith(EasyMockRunner.class)
public class MathApplicationTester {

	@TestSubject
	MathApplication mathApplication = new MathApplication();

	@Mock(type = MockType.STRICT)
	CalculatorService calcService;

	@Test
	public void testAdd() {
		
		calcService.serviceUsed();
		expect(calcService.add(10.0, 20.0)).andReturn(30.00);
		expectLastCall();
		
		replay(calcService);

		assertEquals(mathApplication.add(10.0, 20.0), 30.0, 0);
		
		verify(calcService);
	}
	
	@Test
	public void testSubtract() {
		expect(calcService.subtract(10.0, 20.0)).andReturn(30.00);
		expect(calcService.multiply(10.0, 20.0)).andReturn(30.00);

		replay(calcService);

		assertEquals(mathApplication.subtract(10.0, 20.0), 30.0, 0);		
		assertEquals(mathApplication.multiply(10.0, 20.0), 30.0, 0);
		
		verify(calcService);
	}
	
	
}
