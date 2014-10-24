package net.cjred.scheduler.timertask;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class JobTimer extends TimerTask {

  public void run() {
    Calendar date = Calendar.getInstance();
    String stamp = date.get(Calendar.HOUR_OF_DAY)+":"
            +date.get(Calendar.MINUTE)+":"
            +date.get(Calendar.SECOND)+":"
            +date.get(Calendar.MILLISECOND);
    System.out.println(stamp +" " + "Generating report");


  }

}

class MainApplication {

  public static void main(String[] args) {
    Timer timer  = new Timer();
    Calendar date = Calendar.getInstance();
    date.set(
      Calendar.DAY_OF_WEEK,
      Calendar.SUNDAY
    );
    date.set(Calendar.HOUR, 0);
    date.set(Calendar.MINUTE, 0);
    date.set(Calendar.SECOND, 0);
    date.set(Calendar.MILLISECOND, 0);
    // Schedule to run every Sunday in midnight
    timer.schedule(
      new JobTimer(),
      date.getTime(),
      1000 * 5
      //1000 * 60 * 60 * 24 * 7
    );
  }
}
