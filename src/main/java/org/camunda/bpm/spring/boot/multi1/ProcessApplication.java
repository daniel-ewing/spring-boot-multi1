package org.camunda.bpm.spring.boot.multi1;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.camunda.bpm.spring.boot.starter.event.PostDeployEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@EnableProcessApplication
@Slf4j
public class ProcessApplication {

	@Autowired
	private RuntimeService runtimeService;

	@EventListener
	private void processPostDeploy(PostDeployEvent event) {
		log.info("-----> processPostDeploy: Enter");

		for (int pi = 1; pi <= 1; pi++) {
			runtimeService.startProcessInstanceByKey("multi-instance", "Multi Instance BK");
			if ((pi % 1000) == 0) {
				log.info("-----> processPostDeploy created: {} process instances", pi);
			}
		}

		log.info("-----> processPostDeploy: Exit");
	}
	
	public static void main(String... args) {
		SpringApplication.run(ProcessApplication.class, args);
	}
}