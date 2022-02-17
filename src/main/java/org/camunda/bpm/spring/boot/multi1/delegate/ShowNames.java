package org.camunda.bpm.spring.boot.multi1.delegate;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class ShowNames implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        if (log.isDebugEnabled()) log.debug("-----> execute: Enter");

        List<String> names = (ArrayList<String>) delegateExecution.getVariable("names");
        String name = (String) delegateExecution.getVariable("name");
        if (log.isDebugEnabled()) log.debug("-----> execute: names = {}  --  name = {}", names, name);

        if (log.isDebugEnabled()) log.debug("-----> execute: Exit");
    }
}
