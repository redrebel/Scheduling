package net.cjred.scheduler.quartz.JobListener;
/**
 * Quartz+CronTrigger
 * Created by cjred77@gmail.com on 2014-10-24.
 */

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.GroupMatcher;
import org.quartz.impl.matchers.KeyMatcher;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;


public class QuartzJobListener {
  public static void main(String[] args) {
    try {
      // Grab the Scheduler instance from the Factory
      Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
      // and start it off
      scheduler.start();

      // define the job and tie it to our HelloJob class
      JobKey jobKey = new JobKey("job1", "group1");
      JobDetail job = newJob(MyJobFailed.class)
              .withIdentity(jobKey)
              .build();

      // Trigger the job to run now, ss mm hh dd MM Week
      Trigger trigger = newTrigger()
              .withIdentity("trigger1", "group1")
              .withSchedule(cronSchedule("0/5 * * * * ?"))
              .build();

      // no matcher == match all jobs
      //scheduler.getListenerManager().addJobListener(new MyJobFailedListener());

      // match (listen to) all jobs in given group
      scheduler.getListenerManager().addJobListener(new MyJobFailedListener(), GroupMatcher.jobGroupEquals("group1"));
      //scheduler.getListenerManager().addJobListener(new MyJobFailedListener(), KeyMatcher.keyEquals(jobKey));


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
