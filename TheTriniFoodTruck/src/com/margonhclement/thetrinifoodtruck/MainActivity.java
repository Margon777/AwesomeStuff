package com.margonhclement.thetrinifoodtruck;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		Thread splashtimer = new Thread(){
			public void run(){
				
				try {
					sleep(3000);
					Intent menuIntent = new Intent("com.margonhclement.thetrinifoodtruck.Menu");
					startActivity(menuIntent);
				} catch(InterruptedException e){
					e.printStackTrace();
				}
				finally
				{
					finish();
				}
			}
			
			
		};
		splashtimer.start();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}



}
