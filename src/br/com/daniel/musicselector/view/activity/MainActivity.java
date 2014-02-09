package br.com.daniel.musicselector.view.activity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import br.com.daniel.musicselector.controller.SecondActivity;

;

public class MainActivity extends Activity {
	Activity myActivity = null;
	private static final String TAG = "";
	Button b1, b2, b3, b4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		try {
			myActivity
					.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);// Force
																						// LandScape
		} catch (Exception e) {
			Log.e("Falha no Sensor de Orientação", TAG);
			/*
			 * TAG Used to identify the source of a log message. It usually
			 * identifies the class or activity where the log call occurs.
			 */
		}
		b1 = (Button) findViewById(R.id.button1);
		b2 = (Button) findViewById(R.id.button2);
		b3 = (Button) findViewById(R.id.button3);
		b4 = (Button) findViewById(R.id.button4);

		createListeners();
	}
	
	public void startSecondActivity(int buttonNum) {
		Intent intent = new Intent(this, SecondActivity.class);
		intent.putExtra("BUTTON NUMBER", buttonNum);
		startActivity(intent);
	}

	private void createListeners() {
		
		b1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				startSecondActivity(1);
			}
		});

		b2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				startSecondActivity(2);

			}
		});

		b3.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				startSecondActivity(3);
			}
		});

		b4.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				startSecondActivity(4);
			}
		});
	}



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
