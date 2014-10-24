package net.cjred.scheduler.quartz.quickstart;


import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import static org.quartz.JobBuilder.*;
import static org.quartz.TriggerBuilder.*;
import static org.quartz.SimpleScheduleBuilder.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QuartzTest {

  private static Logger logger = LoggerFactory.getLogger(QuartzTest.class);
  
  
  public static void main(String[] args) {
    try{
      // Grab the Scheduler instance from the Factory
      Scheduler scheduler  = StdSchedulerFactory.getDefaultScheduler();
      //logger.info("d");
      // and start it off
      scheduler.start();
      
      // define the job and tie it to our HelloJob class
      JobDetail job = newJob(Hello.class)
      .withIdentity("job1","group1")
      .build();
      
      // Trigger the job to run now, and then repeat every 40 seconds
      Trigger trigger = newTrigger()
          .withIdentity("trigger1","group1")
          .startNow()
          .withSchedule(simpleSchedule()
              .withIntervalInSeconds(5)
              .repeatForever())
          .build();
      
      // Tell quartz to schedule the job using out trigger
      scheduler.scheduleJob(job, trigger);
      
      try {
        Thread.sleep(60000);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      scheduler.shutdown();
    }catch(SchedulerException se){
      se.printStackTrace();
    }

  }

}
