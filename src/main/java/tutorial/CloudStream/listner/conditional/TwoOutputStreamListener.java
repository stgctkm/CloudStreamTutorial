package tutorial.CloudStream.listner.conditional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import tutorial.CloudStream.processor.TwoOutputProcessor;

@Component
public class TwoOutputStreamListener {
    @Autowired
    TwoOutputProcessor processor;

    @StreamListener(TwoOutputProcessor.INPUT)
    public void routeValues(Integer value) {
        logger.info("* TwoOutputStreamListener.routeValues... ");
        if (value < 10) {
            processor.anOutput().send(message(value));
        } else {
            processor.anotherOutput().send(message(value));
        }
    }

    private static <T> Message<T> message(T val) {
        return MessageBuilder.withPayload(val)
                .build();
    }

    Logger logger = LoggerFactory.getLogger(this.getClass());
}
