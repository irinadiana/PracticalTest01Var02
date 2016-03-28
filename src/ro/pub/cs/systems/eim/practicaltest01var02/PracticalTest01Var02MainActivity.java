package ro.pub.cs.systems.eim.practicaltest01var02;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class PracticalTest01Var02MainActivity extends Activity {

	Button set = null;
	EditText nr1 = null, nr2 = null, nr3 = null, nr4 = null;
	private IntentFilter intentFilter = new IntentFilter();
	
	class ApasaButon implements View.OnClickListener {

		@Override
		public void onClick(View v) {
			
			
			
			// TODO Auto-generated method stub
			if (v.getId() == R.id.buton) {
				if ((nr1.getText().toString().isEmpty() == false) &&
						(nr2.getText().toString().isEmpty() == false) &&
						(nr3.getText().toString().isEmpty() == false) &&
						(nr4.getText().toString().isEmpty() == false)) {
							Intent intent = new Intent(getApplicationContext(), PracticalTest01Var02SecondaryActivity.class);
							intent.putExtra("nr1", nr1.getText().toString());
							intent.putExtra("nr2", nr2.getText().toString());
							intent.putExtra("nr3", nr3.getText().toString());
							intent.putExtra("nr4", nr4.getText().toString());
							
							startActivityForResult(intent, 100);
				}
			}
			
			Intent intent = new Intent(getApplicationContext(), PracticalTest01Var02Service.class);
			startService(intent);
			
		}
	}
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practical_test01_var02_main);
		
		ApasaButon ap = new ApasaButon();
		
		set = (Button)findViewById(R.id.buton);
		set.setOnClickListener(ap);
				
		nr1 = (EditText)findViewById(R.id.nr1);
		
		nr2 = (EditText)findViewById(R.id.nr2);
		
		nr3 = (EditText)findViewById(R.id.nr3);
		
		nr4 = (EditText)findViewById(R.id.nr4);
		
		intentFilter.addAction("integer");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.practical_test01_var02_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	
	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
    	switch(requestCode) {
    	  case 100:
    	    Toast.makeText(getApplication(), "Secondary Activity returned with result " + resultCode, Toast.LENGTH_LONG).show();
    	    break;
    	 }
    }
	
	@Override
	protected void onSaveInstanceState(Bundle savedInstanceState) {
	  super.onSaveInstanceState(savedInstanceState);
	  savedInstanceState.putString("nr1", nr1.getText().toString());
	  savedInstanceState.putString("nr2", nr2.getText().toString());
	  savedInstanceState.putString("nr3", nr3.getText().toString());
	  savedInstanceState.putString("nr4", nr4.getText().toString());
	}
	
	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
	  super.onRestoreInstanceState(savedInstanceState);
	  if (savedInstanceState.getString("nr1") != null) {
	      nr1.setText(savedInstanceState.getString("nr1"));
	  }
	  if (savedInstanceState.getString("nr2") != null) {
	      nr2.setText(savedInstanceState.getString("nr2"));
	  }
	  if (savedInstanceState.getString("nr3") != null) {
	      nr3.setText(savedInstanceState.getString("nr3"));
	  }
	  if (savedInstanceState.getString("nr4") != null) {
	      nr4.setText(savedInstanceState.getString("nr4"));
	  }
	}
	
	private MessageBroadcastReceiver messageBroadcastReceiver = new MessageBroadcastReceiver();
	private class MessageBroadcastReceiver extends BroadcastReceiver {
		
		@Override
		public void onReceive(Context context, Intent intent) {
			// TODO Auto-generated method stub
			String numar1 = intent.getStringExtra("nr1");
			String numar2 = intent.getStringExtra("nr2");
			String numar3 = intent.getStringExtra("nr3");
			String numar4 = intent.getStringExtra("nr4");
			nr1.setText(numar1);
			nr2.setText(numar2);
			nr3.setText(numar3);
			nr4.setText(numar4);
		}
	}
	
	@Override
	protected void onDestroy() {
	  Intent intent = new Intent(this, PracticalTest01Var02Service.class);
	  stopService(intent);
	  super.onDestroy();
	}
	
}
