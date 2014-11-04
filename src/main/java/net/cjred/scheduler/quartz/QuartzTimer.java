package net.cjred.scheduler.quartz;


import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import static org.quartz.JobBuilder.*;
import static org.quartz.TriggerBuilder.*;
import static org.quartz.SimpleScheduleBuilder.*;


public class QuartzTimer {

  //private static Logger logger = LoggerFactory.getLogger(QuartzTimer.class);
  
  
  public static void main(String[] args) {
    try{
      // Grab the Scheduler instance from the Factory
      Scheduler scheduler  = StdSchedulerFactory.getDefaultScheduler();
      // and start it off
      scheduler.start();
      
      // define the job and tie it to our HelloJob class
      JobDetail job = newJob(MyJob.class)
      .withIdentity("job1","group1")
      .build();
      
      // Trigger the job to run now, and then repeat every 5 seconds
      Trigger trigger = newTrigger()
          .withIdentity("trigger1","group1")
          .startNow()
          .withSchedule(simpleSchedule()
              .withIntervalInSeconds(5)
              .repeatForever())
          .build();
      
      // Tell quartz to schedule the job using out trigger
      scheduler.scheduleJob(job, trigger);
      
      Thread.sleep(60000);

      scheduler.shutdown();

    }catch(SchedulerException se){
      se.printStackTrace();
    }catch (InterruptedException e) {
      e.printStackTrace();
    }

  }

}
