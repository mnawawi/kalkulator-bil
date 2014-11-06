package com.redz.ayambranded;



import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import com.elektrik.kalkulator.R;

public class Splash extends Activity{

	MediaPlayer ourSound;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		ourSound = MediaPlayer.create(Splash.this, R.raw.electricsound);
		ourSound.start();
		Thread timer = new Thread(){
			public void run(){
				try {
					sleep(3000);
				}catch (InterruptedException e){
					e.printStackTrace();
				}finally{
					 Intent i = new Intent(Splash.this, Menu.class);
					startActivity(i);
				}
			};
		};
		timer.start();
		
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		ourSound.release();
		finish();
	}

	
}
