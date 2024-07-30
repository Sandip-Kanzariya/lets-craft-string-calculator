package project.calculator.service;

public class StringServiceImpl implements StringService{
	
	@Override
	public int add(String numbers) {
		
		System.out.println("Input : " + numbers);
		
		// Replace all non-numeric characters with space 
	    String numericString = numbers.replaceAll("[^0-9]", " "); 
	    
	    // Split the input string by spaces (or other delimiters) to get individual numbers
	    String[] tokens = numericString.split("\\s+");
	    
	    // Sum the numbers
	    int sum = 0;
	    for (String token : tokens) {
	    	System.out.println(token);
	    	if(!token.isEmpty()) {
	    		sum += Integer.parseInt(token);	    		
	    	}
	    }
	    
		return sum;
	}
}
