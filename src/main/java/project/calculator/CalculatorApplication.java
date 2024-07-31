package project.calculator;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

import project.calculator.service.StringService;

@SpringBootApplication
public class CalculatorApplication
{
	@Autowired
    private StringService stringService;

    public static void main(String[] args) {
        SpringApplication.run(CalculatorApplication.class, args);
    }

    @EventListener(ContextRefreshedEvent.class)
    public void runAfterStartup() {
    	System.out.println("*********** String Calculator **********");

    	Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter the string of numbers (or type 'exit' to quit):");
            String input = scanner.nextLine();

            if ("exit".equalsIgnoreCase(input)) {
                System.out.println("Exiting...");
                break;
            }

            try {
                int result = stringService.add(input);
                System.out.println("Result: " + result);
            } catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }

}
