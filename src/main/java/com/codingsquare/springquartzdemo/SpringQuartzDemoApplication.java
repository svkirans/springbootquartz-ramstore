package com.codingsquare.springquartzdemo;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.SimpleTrigger;
import org.quartz.TriggerBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringQuartzDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringQuartzDemoApplication.class, args);
	}
	
	@Bean
	public JobDetail sampleJobDetail() {
		return JobBuilder.newJob(SampleJob.class).withIdentity("sampleJob")
				.storeDurably().build();
	}
	
	@Bean
	public SimpleTrigger sampleJobTrigger() {
		SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
				.withIntervalInSeconds(20).repeatForever();
		return TriggerBuilder.newTrigger().forJob(sampleJobDetail())
				.withIdentity("sampleTrigger").withSchedule(scheduleBuilder).build();
	}
	
	@Bean
	public CronTrigger sampleCronJobTrigger() {
		CronScheduleBuilder cronBuilder = CronScheduleBuilder.cronSchedule("0 0/1 * 1/1 * ? *");
		return TriggerBuilder.newTrigger().forJob(sampleJobDetail())
				.withIdentity("sampleCronTrigger").withSchedule(cronBuilder).build();
	}
}
