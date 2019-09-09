package tutorial.CloudStream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;
import tutorial.CloudStream.processor.TwoOutputProcessor;


@SpringBootApplication
@EnableBinding({Processor.class, TwoOutputProcessor.class})
public class CloudStreamApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudStreamApplication.class, args);
	}

}
