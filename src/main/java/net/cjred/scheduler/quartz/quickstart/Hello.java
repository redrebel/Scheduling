package net.cjred.scheduler.quartz.quickstart;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class Hello implements Job {

  public void execute(JobExecutionContext arg0) throws JobExecutionException {
    // TODO Auto-generated method stub
    System.out.println("HHHHH");

  }


}
