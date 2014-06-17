package com.margonhermasclement.firstapp;

import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) 
		{
			super.onCreate(savedInstanceState);
			setContentView(R.layout.splash);
			Thread splashtimer = new Thread(){
				public void run(){
					
					try {
						sleep(3000);
						Intent menuIntent = new Intent("com.margonhermasclement.firstapp.Menu");
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
	


}
