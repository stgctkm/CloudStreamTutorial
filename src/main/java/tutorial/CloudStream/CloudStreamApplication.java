package tutorial.CloudStream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
//@EnableBinding({Processor.class, TwoOutputProcessor.class})
public class CloudStreamApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudStreamApplication.class, args);
	}

}
