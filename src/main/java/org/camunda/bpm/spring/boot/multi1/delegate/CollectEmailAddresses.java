package org.camunda.bpm.spring.boot.multi1.delegate;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class CollectEmailAddresses implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        log.info("-----> execute: Enter");

        List<String> emailAddresses;
        synchronized (delegateExecution) {
            emailAddresses = (ArrayList<String>) delegateExecution.getVariable("emailAddresses");
            if (emailAddresses == null) {
                emailAddresses = new ArrayList<>();
            }
        }
        String localEmail = (String) delegateExecution.getVariable("localEmail");
        emailAddresses.add(localEmail);
        delegateExecution.setVariable("emailAddresses",emailAddresses);
        log.info("-----> emailAddresses = {}", emailAddresses.toString());

        log.info("-----> execute: Exit");
    }
}
