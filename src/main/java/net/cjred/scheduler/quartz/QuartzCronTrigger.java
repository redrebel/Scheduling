package net.cjred.scheduler.quartz;
/**
 * Quartz+CronTrigger
 * Created by cjred77@gmail.com on 2014-10-24.
 */
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;
import static org.quartz.CronScheduleBuilder.*;


public class QuartzCronTrigger {
  public static void main(String[] args) {
    try {
      // Grab the Scheduler instance from the Factory
      Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
      //logger.info("d");
      // and start it off
      scheduler.start();

      // define the job and tie it to our HelloJob class
      JobDetail job = newJob(Hello.class)
              .withIdentity("job1", "group1")
              .build();

      // Trigger the job to run now, ss mm hh dd MM Week
      Trigger trigger = newTrigger()
              .withIdentity("trigger1", "group1")
              .withSchedule(cronSchedule("0/10 * 18 * * ?"))
              .build();

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
