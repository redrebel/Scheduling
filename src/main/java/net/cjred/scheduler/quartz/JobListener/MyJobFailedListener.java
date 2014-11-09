package net.cjred.scheduler.quartz.JobListener;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;

/**
 * Created by red on 2014. 11. 7..
 */
public class MyJobFailedListener implements JobListener{

    @Override
    public String getName() {
        return "FAILED JOB";
    }

    @Override
    public void jobToBeExecuted(JobExecutionContext jobExecutionContext) {

    }

    @Override
    public void jobExecutionVetoed(JobExecutionContext jobExecutionContext) {

    }

    @Override
    public void jobWasExecuted(JobExecutionContext jobExecutionContext, JobExecutionException e) {
        if(e != null){
            System.out.println("Report generation error");

        }
    }
}
