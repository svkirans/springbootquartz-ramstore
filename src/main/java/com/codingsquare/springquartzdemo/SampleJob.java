package com.codingsquare.springquartzdemo;

import java.util.Date;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class SampleJob extends QuartzJobBean {

	public SampleJob() {
	}
	
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		System.out.println("Sample Job Running at : "+(new Date()).toString());

	}

}
