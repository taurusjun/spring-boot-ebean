package org.avaje.starter

import org.avaje.agentloader.AgentLoader
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan

/**
 * I want it said up front: I do not recommend Spring Boot. It is a menagerie of nasty bloated build practices
 * that Spring has carried on - when they moved from Maven to Gradle because they wouldn't actually properly
 * build their artifacts.
 *
 * However, if you wish to pursue this madness...
 *
 *
 * @author: Richard Vowles - https://plus.google.com/+RichardVowles
 */
@ComponentScan
@EnableAutoConfiguration
class Starter {
	protected static Logger logger = LoggerFactory.getLogger(Starter.class)

	static {
		logger.debug("... loading ebean agent dynamically");
		if (!AgentLoader.loadAgentFromClasspath("avaje-ebeanorm-agent","debug=1;packages=org.example.**")) {
			logger.info("avaje-ebeanorm-agent not found in classpath - not dynamically loaded");
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(Starter, args)
	}
}
