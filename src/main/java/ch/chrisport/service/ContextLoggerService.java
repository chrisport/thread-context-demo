package ch.chrisport.service;

import org.springframework.scheduling.annotation.Async;

public interface ContextLoggerService {

    @Async
    void logContext();
}
