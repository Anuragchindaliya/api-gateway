package in.anurag.gatekeeper.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiManagementServiceApplication {

	public static void main(String[] args) {
		System.out.println("server startee");
		SpringApplication.run(ApiManagementServiceApplication.class, args);
	}

}
