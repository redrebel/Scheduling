package net.cjred.scheduler.quartz.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by cjred77@gmail.com on 2014. 10. 25..
 * for Quartz 2.2.1
 */
public class QuartzSpring {
    public static void main(String[] args) throws Exception{
        new ClassPathXmlApplicationContext("quartz2.2.1.xml");
    }
}
