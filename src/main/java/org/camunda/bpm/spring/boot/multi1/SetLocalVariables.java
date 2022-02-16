package org.camunda.bpm.spring.boot.multi1;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SetLocalVariables implements JavaDelegate {
    private final static Logger LOGGER = LoggerFactory.getLogger(SetLocalVariables.class);

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        LOGGER.info("-----> SetLocalVariables.execute: Enter");

        String taskNumber = (String) delegateExecution.getVariable ("taskNumber");
        LOGGER.info("-----> taskNumber = {}", taskNumber);
        delegateExecution.setVariableLocal("localTaskNumber", taskNumber);

        LOGGER.info("-----> SetLocalVariables.execute: Exit");
    }
}
