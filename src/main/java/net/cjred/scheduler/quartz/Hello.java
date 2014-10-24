package net.cjred.scheduler.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Calendar;

public class Hello implements Job {

  public void execute(JobExecutionContext arg0) throws JobExecutionException {
    Calendar date = Calendar.getInstance();
    String stamp = date.get(Calendar.HOUR_OF_DAY)+":"
            +date.get(Calendar.MINUTE)+":"
            +date.get(Calendar.SECOND)+":"
            +date.get(Calendar.MILLISECOND);
    System.out.println(stamp +" " + "Generating report");

  }


}
