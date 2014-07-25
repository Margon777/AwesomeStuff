package com.margonhclement.thetrinifoodtruck;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Select_Stage extends Activity {
	
	public static final String Prefs_Name = "MyPreferencesFile";
	int stagechosen;
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);

	    setContentView(R.layout.select_stage);
	    
	   
	    
	    
		Button Stage1 = (Button) findViewById(R.id.stg1);
		Stage1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				 SharedPreferences app_preferences = getSharedPreferences(Prefs_Name, 0);
				 SharedPreferences.Editor editor = app_preferences.edit();
				 editor.putInt("Selected", 1);
				 editor.commit();
				startActivity(new Intent("com.margonhclement.thetrinifoodtruck.HomePage"));
			}
			
		});
		
		Button Stage2 = (Button) findViewById(R.id.stg2);
		Stage2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				 SharedPreferences app_preferences = getSharedPreferences(Prefs_Name, 0);
				 SharedPreferences.Editor editor = app_preferences.edit();
				 editor.putInt("Selected", 2);
				 editor.commit();
				startActivity(new Intent("com.margonhclement.thetrinifoodtruck.HomePage"));
			}
			
		});
		
		Button Stage3 = (Button) findViewById(R.id.stg3);
		Stage3.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				 SharedPreferences app_preferences = getSharedPreferences(Prefs_Name, 0);
				 SharedPreferences.Editor editor = app_preferences.edit();
				 editor.putInt("Selected", 3);
				 editor.commit();
				startActivity(new Intent("com.margonhclement.thetrinifoodtruck.HomePage"));
			}
			
		});
		
		Button toShop = (Button) findViewById(R.id.goShop);
		toShop.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent("com.margonhclement.thetrinifoodtruck.Shop"));
			}
		});
		

	}
	

	
	
	
}
