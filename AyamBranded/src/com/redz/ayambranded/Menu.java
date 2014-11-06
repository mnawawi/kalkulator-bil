package com.redz.ayambranded;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.Button;
import com.elektrik.kalkulator.R;

public class Menu extends Activity {
	
	MediaPlayer ourSound, ourSound3;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);
		final Button back=(Button) findViewById(R.id.bKira);
		final Button arahan=(Button) findViewById(R.id.bArahan);
		final Button informasi=(Button) findViewById(R.id.bInfo);
		final Button toast=(Button) findViewById(R.id.btoast);
		final Button keluar=(Button) findViewById(R.id.bkeluar);
		ourSound = MediaPlayer.create(Menu.this, R.raw.button2);
		
	
		back.setOnClickListener(new View.OnClickListener(){
		@Override
		 public void onClick(View v )
		   {
			// TODO Auto-generated method stub					
		   Intent i = new Intent(Menu.this, MainActivity.class);
		   startActivity(i);
			ourSound.start();
		
			
			
		   }
			   
		   });
		arahan.setOnClickListener(new View.OnClickListener(){
			@Override
			 public void onClick(View v )
			   {
				// TODO Auto-generated method stub					
			   Intent i = new Intent(Menu.this, Arahan.class);
			   startActivity(i);
				ourSound.start();
				
			
			   }			   
			
			   });
		informasi.setOnClickListener(new View.OnClickListener(){
			@Override
			 public void onClick(View v )
			   {
				// TODO Auto-generated method stub					
			   Intent i = new Intent(Menu.this, Informasi.class);
			   startActivity(i);
				ourSound.start();
				
			   }
		
		});
		keluar.setOnClickListener(new View.OnClickListener(){
			@Override
			 public void onClick(View v )
			   {
				// TODO Auto-generated method stub					
			  
				ourSound.start();
				finish();
				System.exit(0);
			
				
				
			   }
				   
		});
			   
	}}