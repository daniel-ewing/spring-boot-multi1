package org.camunda.bpm.spring.boot.multi1;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.camunda.bpm.spring.boot.starter.event.PostDeployEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.EventListener;

@SpringBootApplication

@EnableProcessApplication

public class ProcessApplication1 {
	private final static Logger LOGGER = LoggerFactory.getLogger(ProcessApplication1.class);

	@Autowired
	private RuntimeService runtimeService;

	@EventListener
	private void processPostDeploy(PostDeployEvent event) {
		LOGGER.info("-----> ProcessApplication1.processPostDeploy: Enter");

		for (int pi = 1; pi <= 1; pi++) {
			runtimeService.startProcessInstanceByKey("multi-instance", "Multi Instance BK");
			if ((pi % 1000) == 0) {
				LOGGER.info("-----> ProcessApplication1.processPostDeploy created: {} process instances", pi);
			}
		}

		LOGGER.info("-----> ProcessApplication1.processPostDeploy: Exit");
	}
	
	public static void main(String... args) {
		SpringApplication.run(ProcessApplication1.class, args);

	}
}