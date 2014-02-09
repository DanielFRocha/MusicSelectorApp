package br.com.daniel.musicselector.controller;

import java.net.ContentHandler;

import br.com.daniel.musicselector.view.activity.R;
import br.com.daniel.musicselector.view.activity.R.layout;
import br.com.daniel.musicselector.view.activity.R.menu;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends Activity {
	Activity myActivity = null;
	private static final String TAG = ""; //Empty not null 
	private MediaPlayer mPlayer;
	private int currentSong = 0;
	private int number;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		
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
		Intent intent = getIntent();

		/*
		 * the method getting intent receives data from another Activity
		 * getIntent() will retrieve the Intent that was used to start the
		 * current Activity (screen)
		 */

		number = intent.getIntExtra("BUTTON NUMBER", 0);

		/*
		 * It stores in the integer "number" the button number of the pressed
		 * button, providing a default value of 1 in case it fails.
		 */

		TextView tv = (TextView) findViewById(R.id.textView);
		tv.setText(String.valueOf(number)); // convert a Received Number to a
											// String

		switch (number) {

		case 1:
			mPlayer = MediaPlayer.create(SecondActivity.this, R.raw.song1);
			currentSong = R.raw.song1;
			break;

		case 2:
			mPlayer = MediaPlayer.create(SecondActivity.this, R.raw.song2);
			currentSong = R.raw.song2;
			break;
			
		case 3:
			mPlayer = MediaPlayer.create(SecondActivity.this, R.raw.song3);
			currentSong = R.raw.song3;
			break;
			
		case 4:
			mPlayer = MediaPlayer.create(SecondActivity.this, R.raw.song4);
			currentSong = R.raw.song4;
			break;

		default:

			break;
		}

		mPlayer.start();
	}

	@Override
	protected void onPause() {
		super.onPause();
		if (mPlayer.isPlaying()) {
			mPlayer.pause();
		}
	}

	@Override
	protected void onResume() {
		super.onResume();
		if (mPlayer == null) {
			mPlayer = MediaPlayer.create(SecondActivity.this, currentSong);
		}

		mPlayer.start();
	}

	@Override
	protected void onStop() {
		super.onStop();

		if (mPlayer.isPlaying()) {
			mPlayer.stop();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.second, menu);
		return true;
	}

}
