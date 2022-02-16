package org.camunda.bpm.spring.boot.multi1;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class SetVariables implements JavaDelegate {
    private final static Logger LOGGER = LoggerFactory.getLogger(SetVariables.class);

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        LOGGER.info("-----> SetVariables.execute: Enter");

        ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList("A", "B", "C"));
        delegateExecution.setVariable("taskNumbers", arrayList);

        LOGGER.info("-----> SetVariables.execute: Exit");
    }
}
