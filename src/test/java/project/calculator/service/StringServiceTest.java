package project.calculator.service;

import org.junit.Test;

import java.util.Scanner;

import org.junit.Assert;

public class StringServiceTest {

	/*
	 * Add test Cases For StringService.add Service
	 * 
	 */
	private StringService stringService = new StringServiceImpl();
	
//	public StringServiceTest(StringService stringService){
//		this.stringService = stringService;
//	}
	
	public StringServiceTest(){
		
	}
	@Test
    public void testAddEmptyString() {
        int result = stringService.add("");
        int expected = 0;
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testAddMultipleNumbers() {
        int result = stringService.add("4,5,5,6");
        int expected = 20;
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testAddWithSpaces() {
        int result = stringService.add("2 1 3 45 56 67");
        int expected = 2 + 1 + 3 + 45 + 56 + 67;
        Assert.assertEquals(expected, result);
    }
}
