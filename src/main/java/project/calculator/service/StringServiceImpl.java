package project.calculator.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import project.calculator.exception.NegativeNumberException;

@Service
public class StringServiceImpl implements StringService{
	
	@Override
	public int add(String numbers) {
		
		System.out.println("Input : " + numbers);
		
		// Replace all non-numeric characters with space 
	    String numericString = numbers.replaceAll("[^0-9-]", " "); 
	    
	    // Split the input string by spaces (or other delimiters) to get individual numbers
	    String[] tokens = numericString.split("\\s+");
	    
	    
	    List<Integer> negatives = new ArrayList<>();
	    // Sum the numbers
	    int sum = 0;
	    for (String token : tokens) {
	    	if(!token.isEmpty()) {
	    		int number = Integer.parseInt(token);
                if (number < 0) {
                    negatives.add(number);
                } else {
                    sum += number;
                }	    		
	    	}
	    }
	    
	    if (!negatives.isEmpty()){
	    	throw new NegativeNumberException("negative numbers not allowed: " + negatives);
        }
		return sum;
	}
}
