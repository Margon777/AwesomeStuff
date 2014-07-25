package com.margonhclement.thetrinifoodtruck;

import java.util.Random;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class HomePage extends Activity {

	int outer1[] = { R.drawable.aloo_pie, R.drawable.bara, R.drawable.pholourie };
	int choices1[] = { R.drawable.channa, R.drawable.chicken };
	int choices2[] = { R.drawable.pepper, R.drawable.chadon };
	Random ran, dan, tan;

	ImageView firstOne, secondOne, thirdOne, pick1, pick2, pick3, selected, pickin, picked ;
	int l, r, i, x, k, g, d, f, a, b, c, cost, incr;

	// SharedPreferences app_preferences;
	public static final String Prefs_Name = "MyPreferencesFile";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.homepage);
		ran = new Random();
		dan = new Random();
		tan = new Random();
		SharedPreferences app_preferences = getSharedPreferences(Prefs_Name, 0);
		firstOne = (ImageView) findViewById(R.id.imageView1);
		secondOne = (ImageView) findViewById(R.id.imageView2);
		thirdOne = (ImageView) findViewById(R.id.imageView3);
		pickin = (ImageView) findViewById(R.id.Ans1);
		picked= (ImageView) findViewById(R.id.Ans2);
		selected = (ImageView) findViewById(R.id.Ans3);
		final TextView price = (TextView) findViewById(R.id.Money);
		final TextView count = (TextView) findViewById(R.id.timer);
		f = ran.nextInt(choices1.length);
		d = dan.nextInt(choices2.length);
		l = tan.nextInt(outer1.length);
		r = 1;
		k = f;
		g = d;
		firstOne.setImageResource(outer1[l]);
		secondOne.setImageResource(choices2[d]);
		thirdOne.setImageResource(choices1[f]);
		incr = app_preferences.getInt("Buy2", 0);
		if (incr < 1){
			incr = app_preferences.getInt("Buy1", 0);
		}
		if (incr < 1){
			incr = 20;
		} 
		cost = app_preferences.getInt("Price", 0);
		i = app_preferences.getInt("Selected", 0);
		
		if (i == 1) {
			x = 100000;
			incr = incr + 5;
		} else if (i == 2) {
			x = 70000;
			incr = incr + 10;
		} else if (i == 3) {
			x = 30000;
			incr = incr + 15;
		}

		ImageButton randomise = (ImageButton) findViewById(R.id.secItem);

		new CountDownTimer(x, 1000) {

			public void onTick(long millisUntilFinished) {
				count.setText("seconds remaining: " + millisUntilFinished
						/ 1000);
			}

			public void onFinish() {
				
					finish();
			}
		}.start();

		price.setText(Integer.toString(cost));
		randomise.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				SharedPreferences app_preferences = getSharedPreferences(Prefs_Name, 0);
				  			
				cost = Integer.parseInt(price.getText().toString());
			
			
				if (a > -1) {
				   if ( a == l &  b == f & c == d) {
				    	cost = cost + incr;
				    }
				}
				price.setText(Integer.toString(cost));
				Editor editor = app_preferences.edit();
				editor.putInt("Price", cost);
				editor.commit();
		
				f = ran.nextInt(choices1.length);
				thirdOne.setImageResource(choices1[f]);
				d = dan.nextInt(choices2.length);
				secondOne.setImageResource(choices2[d]);
				l = tan.nextInt(outer1.length);
				firstOne.setImageResource(outer1[l]);
				
				a = -1;
				b = -1;
				c = -1;

			}
		});

		ImageButton picking = (ImageButton) findViewById(R.id.thirItem);
		picking.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				a = 1;
				pickin.setImageResource(R.drawable.bara);
			}
		});

		ImageButton select = (ImageButton) findViewById(R.id.fourItem);
		select.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				b = 0;
				selected.setImageResource(R.drawable.channa);
			}

		});

		ImageButton pick = (ImageButton) findViewById(R.id.fifItem);
		pick.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				c = 1;
				picked.setImageResource(R.drawable.chadon);
			}

		});

		ImageButton choose = (ImageButton) findViewById(R.id.sixItem);
		choose.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				c = 0;
				picked.setImageResource(R.drawable.pepper);
			}

		});

		ImageButton mark = (ImageButton) findViewById(R.id.sevItem);
		mark.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				a = 2;
				pickin.setImageResource(R.drawable.pholourie);
			}

		});

		ImageButton point = (ImageButton) findViewById(R.id.eigItem);
		point.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				 b = 1; 
				selected.setImageResource(R.drawable.chicken);
			}

		});

		ImageButton last = (ImageButton) findViewById(R.id.ninItem);
		last.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				a = 0;
				pickin.setImageResource(R.drawable.aloo_pie);
			}

		});
	}

}
