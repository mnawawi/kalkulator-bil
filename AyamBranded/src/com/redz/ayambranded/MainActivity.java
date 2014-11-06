package com.redz.ayambranded;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.app.Activity;
import android.view.Menu;
import java.math.BigDecimal;
import android.widget.Toast;
import com.elektrik.kalkulator.R;

public class MainActivity extends Activity {
	
	private TextView previousTextView;
	private EditText previousTextEdit;
	private TextView currentTextView;
	private EditText currentTextEdit;
	private TextView totalTextView;

	BigDecimal sebelum, selepas, hasil;
	int result, bill;
	float total;
	String jumlah;
	MediaPlayer ourSound, ourSound1;
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		previousTextView = (TextView) findViewById(R.id.previous);
        previousTextView.setText(R.string.view1);
        previousTextEdit = (EditText) findViewById(R.id.previousEditText);
        currentTextView = (TextView) findViewById(R.id.current);
        currentTextView.setText(R.string.view2);
        currentTextEdit = (EditText) findViewById(R.id.currentEditText);
        totalTextView = (TextView) findViewById(R.id.textView1);
    	ourSound = MediaPlayer.create(MainActivity.this, R.raw.button);
    	ourSound1 = MediaPlayer.create(MainActivity.this, R.raw.button3);
    	
        SharedPreferences previousSettings = getSharedPreferences("PreviousPreferences", 0);
		String previousString = previousSettings.getString("Previous", null);
		if (previousString != null) {
			previousTextEdit.setText(previousString);
		}
        
        
        Button button1 = (Button) findViewById(R.id.btoast);
        button1.setOnClickListener(new OnClickListener() {			
			public void onClick(View v) {
				
				SharedPreferences previousSettings = getSharedPreferences("PreviousPreferences", 0);
				SharedPreferences.Editor previousEditor = previousSettings.edit();
				previousEditor.putString("Previous", previousTextEdit.getText().toString());
				previousEditor.commit();
				ourSound.start();
				Toast.makeText(getApplicationContext(),"Data disimpan", Toast.LENGTH_SHORT).show();	
			}
		});
        
        SharedPreferences CurrentSettings = getSharedPreferences("CurrentPreferences", 0);
		String currentString = CurrentSettings.getString("Current", null);
		if (currentString != null) {
			currentTextEdit.setText(currentString);
		}
		
		Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new OnClickListener() {			
			public void onClick(View v) {
				SharedPreferences currentSettings = getSharedPreferences("CurrentPreferences", 0);
				SharedPreferences.Editor currentEditor = currentSettings.edit();
				currentEditor.putString("Current", currentTextEdit.getText().toString());
				currentEditor.commit();
				ourSound.start();
				Toast.makeText(getApplicationContext(),"Data disimpan", Toast.LENGTH_SHORT).show();
			}
		});
        
        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new OnClickListener() {			
			public void onClick(View v) {
				SharedPreferences previousSettings = getSharedPreferences("PreviousPreferences", 0);
				SharedPreferences.Editor previousEditor = previousSettings.edit();
				previousEditor.clear();
				previousEditor.commit();
				ourSound.start();
				Toast.makeText(getApplicationContext(),"Data dipadam", Toast.LENGTH_SHORT).show();
			}
		});
        
        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new OnClickListener() {			
			public void onClick(View v) {
				SharedPreferences currentSettings = getSharedPreferences("CurrentPreferences", 0);
				SharedPreferences.Editor currentEditor = currentSettings.edit();
				currentEditor.clear();
				currentEditor.commit();
				ourSound.start();
				Toast.makeText(getApplicationContext(),"Data dipadam", Toast.LENGTH_LONG).show();
			}
		});
        
        Button button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				
				 sebelum = new BigDecimal(previousTextEdit.getText().toString());
				 selepas = new BigDecimal(currentTextEdit.getText().toString());
				 if (previousTextEdit.getText()==null || (previousTextEdit.getText().toString().isEmpty())){
					Toast.makeText(getApplicationContext(),"Isi ruangan kosong", Toast.LENGTH_LONG).show();}
					if (currentTextEdit.getText()==null|| (currentTextEdit.getText().toString().isEmpty()) ){
						Toast.makeText(getApplicationContext(),"Isi ruangan kosong", Toast.LENGTH_LONG).show();
					}
				 hasil = selepas.subtract(sebelum);
				 calculate();
				 ourSound1.start();
				 totalTextView.setText("RM:" +total); 	 
			}
		});
        		
        
	}

	public void calculate()
	{
		int result = hasil.intValue();
		if(result < 200)
			total = (float) (result*0.218);	
		if(result>200 && result<301)
			total = (float) (((result-200)*0.334) + (200*0.218));
		if(result>300 && result<601)
			total = (float) ((result-300)*0.516 + (200*0.218) + (100*0.334));
		if(result>600 && result<901)
			total = (float) (((result-600)*0.546) + (200*0.218 + (100*0.334) + (300*0.516)));
		if(result>900)
			total = (float) (((result-900)*0.571) + (200*0.218) + (100*0.334) + (300*0.516) + (300*0.546));
	}
}
