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
    if (log.isDebugEnabled()) log.debug("-----> execute: Enter");

        String name = (String) delegateExecution.getVariable ("name");
        String localEmail = name.toLowerCase() + "@beatles.com";
        if (log.isDebugEnabled()) log.debug("-----> execute: name = {}", name);
        delegateExecution.setVariableLocal("localEmail", name.toLowerCase() + "@beatles.com");

        if (log.isDebugEnabled()) log.debug("-----> execute: Exit");
    }

}
