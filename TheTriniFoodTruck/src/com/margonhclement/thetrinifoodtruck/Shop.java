package com.margonhclement.thetrinifoodtruck;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Shop extends Activity {

	public static final String Prefs_Name = "MyPreferencesFile";
	int money, check1, check2;
	
	final Context context = this;

	protected void onCreate(Bundle savedInstanceState){
			
		super.onCreate(savedInstanceState);
		setContentView(R.layout.shop);
		final AlertDialog.Builder alert = new AlertDialog.Builder(context);
		SharedPreferences app_preferences = getSharedPreferences(Prefs_Name, 0);
		final TextView funds = (TextView) findViewById(R.id.Funds);
		money = app_preferences.getInt("Price", 0);
		check1 = app_preferences.getInt("Buy1", 0);
		check2 = app_preferences.getInt("Buy2", 0);
		
		funds.setText(Integer.toString(money));
		Button buy_bike = (Button) findViewById(R.id.BuyB);
		buy_bike.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				SharedPreferences app_preferences = getSharedPreferences(Prefs_Name, 0);
				if (check1 == 50) {
					AlertDialog.Builder alertDialog = new AlertDialog.Builder(
						       Shop.this);
						alertDialog.setNegativeButton("Bike already bought",
						        new DialogInterface.OnClickListener() {
						            public void onClick(DialogInterface dialog, int which) {
						               
						            }
						        });
						alertDialog.show();
				}
				else if (money > 50) {
				money = money - 50;
				funds.setText(Integer.toString(money));
				check1 = 50;
				Editor editor = app_preferences.edit();
				editor.putInt("Price", money);
				editor.putInt("Buy1", check1);
				editor.commit();
				} else
				{
					AlertDialog.Builder alertDialog = new AlertDialog.Builder(
					       Shop.this);
					alertDialog.setNegativeButton("You need over 50 points to purchase the bike",
					        new DialogInterface.OnClickListener() {
					            public void onClick(DialogInterface dialog, int which) {
					              
					               
					            }
					        });
					alertDialog.show();
				}
			}
		});
		
		Button buy_truck = (Button) findViewById(R.id.BuyT);
		buy_truck.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				SharedPreferences app_preferences = getSharedPreferences(Prefs_Name, 0);
				if (check2 == 500) {
					AlertDialog.Builder alertDialog = new AlertDialog.Builder(
						       Shop.this);
						alertDialog.setNegativeButton("Truck already bought",
						        new DialogInterface.OnClickListener() {
						            public void onClick(DialogInterface dialog, int which) {
						              
						             
						            }
						        });
						alertDialog.show();
				}
				else if (money > 50) {
					money = money - 50;
					funds.setText(Integer.toString(money));
					check2 = 500;
					Editor editor = app_preferences.edit();
					editor.putInt("Price", money);
					editor.putInt("Buy2", check2);
					editor.commit();
					} else
					{
			
						
						AlertDialog.Builder alertDialog = new AlertDialog.Builder(
							       Shop.this);
							alertDialog.setNegativeButton("You need over 50 points to purchase the truck",
							        new DialogInterface.OnClickListener() {
							            public void onClick(DialogInterface dialog, int which) {
							              
							               
							            }
							        });
							alertDialog.show();
						
						
					}
			}
		});
		
	}
}
