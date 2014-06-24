package com.margonhermasclement.firstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

public class Menu extends ActionBarActivity{

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
				
				startActivity(new Intent("com.margonhermasclement.firstapp.HomePage"));
				
			}
		});
			
		};
	

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

}

