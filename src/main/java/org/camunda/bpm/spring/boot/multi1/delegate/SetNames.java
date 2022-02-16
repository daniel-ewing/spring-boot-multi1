package org.camunda.bpm.spring.boot.multi1.delegate;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Slf4j
public class SetNames implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        log.info("-----> execute: Enter");

        List<String> names = new ArrayList<>(Arrays.asList("John", "Paul", "Ringo", "George"));
        delegateExecution.setVariable("names", names);

        log.info("-----> execute: Exit");
    }
}
