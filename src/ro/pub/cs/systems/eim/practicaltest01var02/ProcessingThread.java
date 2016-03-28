package ro.pub.cs.systems.eim.practicaltest01var02;

import java.sql.Date;
import java.util.Random;

import android.content.Context;
import android.content.Intent;

public class ProcessingThread extends Thread {
	private Context context;
	private double ma;
	private double mg;
	private Random random = new Random();
	 
	  public ProcessingThread(Context context) {
	    this.context = context;
	  }
	  
	  @Override
	  public void run() {
	    while(true){ 
	      sendMessage();
	      sleep();
	    }
	  }
	  
	  private void sleep() {
		    try {
		      Thread.sleep(10000);
		    } catch (InterruptedException interruptedException) {
		      interruptedException.printStackTrace();
		    }
	  }
	  
	  private void sendMessage() {
		    Intent intent = new Intent();
		    intent.setAction("integer");
			intent.putExtra("nr1", random.nextInt());
			intent.putExtra("nr2", random.nextInt());
			intent.putExtra("nr3", random.nextInt());
			intent.putExtra("nr4", random.nextInt());
		    context.sendBroadcast(intent);
	  }
}
