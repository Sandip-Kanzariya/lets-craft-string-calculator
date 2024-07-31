package project.calculator.service;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import project.calculator.exception.NegativeNumberException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
	
	/*   Basic test cases  */
	@Test
    public void testAddEmptyString() {
        int result = stringService.add("");
        int expected = 0;
        assertThat(result).isEqualTo(expected);
    }
		
    @Test
    public void testAddSingleNumber() {
        int result = stringService.add("4");
        int expected = 4;
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
    
    /* Numbers bigger than 1000 should be ignored */
    
    @Test
    public void testAddLargeNumbers() {
        int result = stringService.add("1000,2000,3");
        int expected = 1000 + 3;
        assertThat(result).isEqualTo(expected);
    }
    
    /* Custom Delimiter & Multiple Delimiters (Include Spaces also)*/
    
    @Test
    public void testAddWithNewLines() {
        int result = stringService.add("1\n2,3");
        int expected = 1 + 2 + 3;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void testAddWithCustomDelimiter() {
        int result = stringService.add("//;\n1;2");
        int expected = 1 + 2;
        assertThat(result).isEqualTo(expected);
    }
    
    @Test
    public void testAddMultipleNumbersWithDifferentDelimiters() {
        int result = stringService.add("1,2\n3 4;5");
        int expected = 1 + 2 + 3 + 4 + 5;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void testAddWithCustomDelimiterAndNewLines() {
        int result = stringService.add("//;\n1;2\n3,4");
        int expected = 1 + 2 + 3 + 4;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void testAddWithConsecutiveDelimiters() {
        int result = stringService.add("1,,2,,3\n\n4");
        int expected = 1 + 2 + 3 + 4;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void testAddWithOnlyDelimiters() {
        int result = stringService.add(",,\n\n;;");
        int expected = 0;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void testAddWithNonNumericCharacters() {
        int result = stringService.add("a1b2c3");
        int expected = 1 + 2 + 3;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void testAddWithLeadingAndTrailingDelimiters() {
        int result = stringService.add(",1,2,3,");
        int expected = 1 + 2 + 3;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void testAddWithMultipleCustomDelimiters() {
        int result = stringService.add("//[;][,]\n1;2,3;4,5");
        int expected = 1 + 2 + 3 + 4 + 5;
        assertThat(result).isEqualTo(expected);
    }
    
    @Test
    public void testAddWithAnyLengthCustomDelimiters() {
        int result = stringService.add("//[***]\\n1***2***3");
        int expected = 1 + 2 + 3;
        assertThat(result).isEqualTo(expected);
    }
    
    @Test
    public void testAddWithDelimiters() {
        int result = stringService.add("//[*][%]\\n1*2%3");
        int expected = 1 + 2 + 3;
        assertThat(result).isEqualTo(expected);
    }

    /*       Negative Number not allowed             */
    
    @Test
    public void testAddWithNegativeNumber() {
        assertThatThrownBy(() -> stringService.add("1,2,-3"))
            .isInstanceOf(NegativeNumberException.class)
            .hasMessageContaining("negative numbers not allowed: [-3]");
    }

    @Test
    public void testAddWithMultipleNegativeNumbers() {
        assertThatThrownBy(() -> stringService.add("1,-2,-3"))
            .isInstanceOf(NegativeNumberException.class)
            .hasMessageContaining("negative numbers not allowed: [-2, -3]");
    }
}
