package ch.chrisport.service.impl;

import ch.chrisport.service.ContextLoggerService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ContextLoggerServiceImpl implements ContextLoggerService {

    @Override
    public void logContext() {
        log.info("Current context: {}    executing Thread ID: {}", MDC.getCopyOfContextMap(), Thread.currentThread().getId());
    }

}
