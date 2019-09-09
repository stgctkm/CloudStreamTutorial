package tutorial.CloudStream.listner.conditional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import tutorial.CloudStream.processor.TwoOutputProcessor;

@Component
@EnableBinding({TwoOutputProcessor.class,})
public class ConditionalStreamListener {
    @Autowired
    TwoOutputProcessor processor;

    @StreamListener(target = TwoOutputProcessor.INPUT, condition = "payload < 10")
    public void routeValues(Integer value) {
        logger.info("* ConditionalStreamListener.routeValues... ");
        processor.anOutput().send(message(value));
    }

    @StreamListener(target = TwoOutputProcessor.INPUT, condition = "payload >= 10")
    public void routeValuesToAnother(Integer value) {
        logger.info("* ConditionalStreamListener.routeValuesToAnother... ");
        processor.anotherOutput().send(message(value));
    }

    private static <T> Message<T> message(T val) {
        return MessageBuilder.withPayload(val)
                .build();
    }
    Logger logger = LoggerFactory.getLogger(this.getClass());
}
