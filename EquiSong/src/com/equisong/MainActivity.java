package com.equisong;

import java.io.IOException;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends Activity {

	MediaPlayer mp;
	Button play, stop, pause;
	Context context;
	
	//Initializer
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mp = MediaPlayer.create(this, R.raw.song);
		
		
		play = (Button) findViewById(R.id.play);
		stop = (Button) findViewById(R.id.stop);
		//pause = (Button) findViewById(R.id.pause);
		
		play.setOnClickListener(mListener);
	}
	
	View.OnClickListener mListener = new OnClickListener() {

		
		public void onClick(View v) {
			switch(v.getId()){
			case R.id.play:
				try {
					mp.prepare();
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				mp.start();
				break;
				
			case R.id.stop:
				mp.pause();
			}
			
		}
		
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
	
	public void play(){
		
	}
}
