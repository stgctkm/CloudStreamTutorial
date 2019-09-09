package tutorial.CloudStream.listner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;
import tutorial.CloudStream.model.LogMessage;

@Component
public class SimpleStreamListener {
    @StreamListener(Processor.INPUT)
    @SendTo(Processor.OUTPUT)
    public LogMessage enrich(LogMessage logMessage) {
        logger.info("* SimpleStreamListener.enrich... ");
        return new LogMessage(String.format("[1]: %s", logMessage.getMessage()));
    }
    Logger logger = LoggerFactory.getLogger(this.getClass());
}
