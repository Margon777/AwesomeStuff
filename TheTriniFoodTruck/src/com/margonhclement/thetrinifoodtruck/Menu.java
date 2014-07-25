package com.margonhclement.thetrinifoodtruck;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Menu extends Activity{

	public static final String Prefs_Name = "MyPreferencesFile";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button Cont = (Button) findViewById(R.id.Btn_Continue);
		Cont.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				startActivity(new Intent("com.margonhclement.thetrinifoodtruck.Select_Stage"));
				
			}
		});
		
		Button newGame = (Button) findViewById(R.id.Btn_New_Game);
		newGame.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				SharedPreferences app_preferences = getSharedPreferences(Prefs_Name, 0);
				Editor editor = app_preferences.edit();
				editor.clear();
				editor.commit();
				startActivity(new Intent("com.margonhclement.thetrinifoodtruck.Select_Stage"));
				
			}
		});
			
		};
	

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}
	
	public void showDialog ()
	{
		
	}
	
	
}
