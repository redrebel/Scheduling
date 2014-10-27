package net.cjred.scheduler.quartz.spring;

import net.cjred.scheduler.quartz.Hello;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * Created by red on 2014. 10. 27..
 */
public class MyJobBean extends QuartzJobBean {

    private Hello hello;
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        hello.print();
    }

    public void setHello(Hello hello){
        this.hello = hello;
    }
}
