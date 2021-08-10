//package com.imran.config;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.Scheduled;
//
//@Configuration
//@EnableScheduling
//@ConditionalOnProperty(prefix = "startup", name = "sync.enabled", havingValue = "true", matchIfMissing = true)
//public class AppScheduler {
//
//	private final Logger LOGGER = LoggerFactory.getLogger(getClass());
//
//	@Scheduled(fixedDelayString = "${fixedDelay.in.milliseconds}")
//	public void getModalityWorkListAsSheduled() {
//		LOGGER.error("JobStartReportPostingForMuna>>>");
//		long startTime = System.nanoTime();
//		System.out.println("startTime#################:" + startTime);
//
//		long endTime = System.nanoTime();
//		System.out.println("endTime###################:" + endTime);
//		long duration = (endTime - startTime);
//		System.out.println("duration###################:" + duration);
//	}
//
//}
