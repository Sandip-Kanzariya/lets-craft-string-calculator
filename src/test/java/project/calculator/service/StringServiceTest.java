package project.calculator.service;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class StringServiceTest {

	/*
	 * Add test Cases For StringService.add Service
	 * 
	 */
	@Autowired
	private StringService stringService;
	
	public StringServiceTest(){
	}
	
	@Test
    public void testAddEmptyString() {
        int result = stringService.add("");
        int expected = 0;
        
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void testAddMultipleNumbers() {
        int result = stringService.add("4,5,5,6");
        int expected = 20;
        
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void testAddWithSpaces() {
        int result = stringService.add("2 1 3 45 56 67");
        int expected = 2 + 1 + 3 + 45 + 56 + 67;
        
        assertThat(result).isEqualTo(expected);
    }
}
