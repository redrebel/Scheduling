package net.cjred.scheduler.quartz.JobListener;

import net.cjred.scheduler.quartz.Hello;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * Created by red on 2014. 10. 25..
 */
public class MyJobFailed implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        Hello hello = new Hello();
        hello.print();
      throw new JobExecutionException();
    }
}
