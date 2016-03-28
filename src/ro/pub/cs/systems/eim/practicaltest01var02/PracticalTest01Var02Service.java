package ro.pub.cs.systems.eim.practicaltest01var02;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class PracticalTest01Var02Service extends Service {

	@Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        ProcessingThread processingThread = new ProcessingThread(this);
        processingThread.start();
        return START_REDELIVER_INTENT;
    }
	
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

}
