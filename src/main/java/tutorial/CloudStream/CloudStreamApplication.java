package tutorial.CloudStream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.SendTo;
import tutorial.CloudStream.model.LogMessage;


@SpringBootApplication
@EnableBinding(Processor.class)
public class CloudStreamApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudStreamApplication.class, args);
	}


	@StreamListener(Processor.INPUT)
    @SendTo(Processor.OUTPUT)
	public LogMessage enrich(LogMessage logMessage) {
	    return new LogMessage(String.format("[1]: %s", logMessage.getMessage()));
    }
}
