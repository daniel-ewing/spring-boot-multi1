package org.camunda.bpm.spring.boot.multi1;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class ShowVariables implements JavaDelegate {
     private final static Logger LOGGER = LoggerFactory.getLogger(ShowVariables.class);

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        LOGGER.info("-----> ShowVariables.execute: Enter");

        ArrayList<String>  taskNumbers = (ArrayList<String>) delegateExecution.getVariable("taskNumbers");
        String taskNumber = (String) delegateExecution.getVariable("taskNumber");
        LOGGER.info("-----> taskNumbers = {}  --  taskNumber = {}",
                taskNumbers.toString(), taskNumber);

        LOGGER.info("-----> ShowVariables.execute: Exit");
    }
}
