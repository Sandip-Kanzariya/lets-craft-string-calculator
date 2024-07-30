package project.calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "project.calculator.service")
public class CalculatorApplication
{
    public static void main( String[] args )
    {
    	SpringApplication.run(CalculatorApplication.class, args);
        System.out.println( "String Calculator : " );
        /* 
	      	System.out.println("Enter Numbers : ");
			Scanner scanner = new Scanner(System.in);
			String numbers = scanner.nextLine();
        */              
    }
    
}
