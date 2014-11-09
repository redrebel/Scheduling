package net.cjred.scheduler.quartz;
/**
 * Quartz+CronTrigger
 * Created by cjred77@gmail.com on 2014-10-24.
 */

import net.cjred.scheduler.quartz.JobListener.MyJobFailedListener;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;
import static org.quartz.impl.matchers.GroupMatcher.*;


public class QuartzJobListener {
  public static void main(String[] args) {
    try {
      // Grab the Scheduler instance from the Factory
      Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
      // and start it off
      scheduler.start();

      // define the job and tie it to our HelloJob class
      JobDetail job = newJob(MyJob.class)
              .withIdentity("job1", "group1")
              .build();

      // Trigger the job to run now, ss mm hh dd MM Week
      Trigger trigger = newTrigger()
              .withIdentity("trigger1", "group1")
              .withSchedule(cronSchedule("0/5 * * * * ?"))
              .build();

      // no matcher == match all jobs
      //scheduler.getListenerManager().addJobListener(new MyJobFailedListener());

      // match (listen to) all jobs in given group
      scheduler.getListenerManager().addJobListener(new MyJobFailedListener(), groupEquals("FAILED JOB"));


      // Tell quartz to schedule the job using out trigger
      scheduler.scheduleJob(job, trigger);

      Thread.sleep(60000);

      scheduler.shutdown();

    } catch (SchedulerException se) {
      se.printStackTrace();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

  }
}
