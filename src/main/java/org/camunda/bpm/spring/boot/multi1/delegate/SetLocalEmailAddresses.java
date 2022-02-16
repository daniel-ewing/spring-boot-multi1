package org.camunda.bpm.spring.boot.multi1.delegate;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import org.springframework.stereotype.Component;


@Component
@Slf4j
public class SetLocalEmailAddresses implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        log.info("-----> execute: Enter");

        String name = (String) delegateExecution.getVariable ("name");
        log.info("-----> name = {}", name);
        delegateExecution.setVariableLocal("localEmail", name.toLowerCase() + "@beatles.com");

        log.info("-----> execute: Exit");
    }

}
