package org.camunda.bpm.spring.boot.multi1.listener;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.HistoryService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.history.HistoricVariableInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class CollectEmailAddresses implements ExecutionListener {

    @Autowired
    HistoryService historyService;

    @Override
    public void notify(DelegateExecution delegateExecution) throws Exception {
        if (log.isDebugEnabled()) log.debug("-----> execute: Enter");

        List<HistoricVariableInstance> historicVariableInstances = historyService.createHistoricVariableInstanceQuery()
                .processInstanceId(delegateExecution.getProcessInstanceId())
                .variableName("localEmail")
                .list();

        List<String> emailAddresses = new ArrayList<>();

        for (HistoricVariableInstance historicVariableInstance : historicVariableInstances) {
            emailAddresses.add(historicVariableInstance.getValue().toString());
        }

        if (log.isDebugEnabled()) log.debug("-----> emailAddresses = {}", emailAddresses);

        if (log.isDebugEnabled()) log.debug("-----> execute: Exit");
    }
}
