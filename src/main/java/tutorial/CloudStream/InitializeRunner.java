package tutorial.CloudStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import tutorial.CloudStream.model.LogMessage;
import tutorial.CloudStream.processor.TwoOutputProcessor;

@Component
class InitializeRunner implements ApplicationRunner {

    @Autowired
    TwoOutputProcessor twoOutputProcessor;

    @Autowired
    Processor processor;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        processor.input().send(MessageBuilder.withPayload(new LogMessage("This is test message")).build());
        twoOutputProcessor.myInput().send(message(5));
        twoOutputProcessor.myInput().send(message(100));
        System.out.println("published ...");
    }

    private static <T> Message<T> message(T val) {
        return MessageBuilder.withPayload(val).build();
    }

}
