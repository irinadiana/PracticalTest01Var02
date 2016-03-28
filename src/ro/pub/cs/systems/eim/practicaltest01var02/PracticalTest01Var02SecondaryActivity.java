package ro.pub.cs.systems.eim.practicaltest01var02;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import ro.pub.cs.systems.eim.practicaltest01var02.PracticalTest01Var02MainActivity.ApasaButon;

public class PracticalTest01Var02SecondaryActivity extends Activity {

	Button sum = null, product;
	EditText nr12 = null, nr22 = null, nr32 = null, nr42 = null;
	
	
	class ApasaButon implements View.OnClickListener {

		@Override
		public void onClick(View v) {
			
			// TODO Auto-generated method stub
			if (v.getId() == R.id.sum) {
				int suma = Integer.parseInt(nr12.getText().toString()) +
						Integer.parseInt(nr22.getText().toString()) +
						Integer.parseInt(nr32.getText().toString()) +
						Integer.parseInt(nr42.getText().toString());
				setResult(suma, null);
				finish();
			}
			
			if (v.getId() == R.id.product) {
				int produs = Integer.parseInt(nr12.getText().toString()) *
						Integer.parseInt(nr22.getText().toString()) *
						Integer.parseInt(nr32.getText().toString()) *
						Integer.parseInt(nr42.getText().toString());
				setResult(produs, null);
				finish();
			}
		}
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practical_test01_var02_secondary);
		
		ApasaButon ap = new ApasaButon();
		
		sum = (Button)findViewById(R.id.sum);
		sum.setOnClickListener(ap);
		
		product = (Button)findViewById(R.id.product);
		product.setOnClickListener(ap);
		
		nr12 = (EditText)findViewById(R.id.nr12);
		
		nr22 = (EditText)findViewById(R.id.nr22);
		
		nr32 = (EditText)findViewById(R.id.nr32);
		
		nr42 = (EditText)findViewById(R.id.nr42);
		
		Intent intent = getIntent();
		if (intent != null) {
		  String nr1 = intent.getStringExtra("nr1");
		  if (nr1 != null) {
		    nr12.setText(nr1);
		  }
		  String nr2 = intent.getStringExtra("nr2");
		  if (nr2 != null) {
		    nr22.setText(nr2);
		  }
		  String nr3 = intent.getStringExtra("nr3");
		  if (nr3 != null) {
		    nr32.setText(nr3);
		  }
		  String nr4 = intent.getStringExtra("nr4");
		  if (nr4 != null) {
		    nr42.setText(nr4);
		  }
		} 
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.practical_test01_var02_secondary, menu);
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
}
