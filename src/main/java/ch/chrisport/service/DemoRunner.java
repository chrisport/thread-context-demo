package ch.chrisport.service;

import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DemoRunner {

    private final ContextLoggerService contextLoggerService;

    @Autowired
    public DemoRunner(ContextLoggerService contextLoggerService) {
        this.contextLoggerService = contextLoggerService;
    }

    @PostConstruct
    public void startCounter() {
        new Thread(() -> {

            for (int i = 0; i < 10; i++) {

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                setContext(i);
                contextLoggerService.logContext();
            }

        }).start();
    }

    private void setContext(int value) {
        MDC.put("count", String.valueOf(value));
        MDC.put("callerThreadId", String.valueOf(Thread.currentThread().getId()));
    }
}
