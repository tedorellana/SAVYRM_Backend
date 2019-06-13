package SAVYRM.PROJECT;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SavyrmApplication {

	public static void main(String[] args) {
            System.out.println("SAVYRM Running main method");
            ApplicationContext applicationContext = SpringApplication.run(SavyrmApplication.class, args);
            
            for (String name : applicationContext.getBeanDefinitionNames()) {
			System.out.println("->" + name);
		}
            
            System.out.println("SAVYRM main method ends");
	}

}
