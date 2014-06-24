package com.margonhermasclement.firstapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;

public class HomePage extends ActionBarActivity implements OnTouchListener{

	Background v;
	Bitmap glove;
	float x,y;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		v = new Background(this);
		v.setOnTouchListener(this);
		glove = BitmapFactory.decodeResource(getResources(), R.drawable.glove );
		x = y = 0;
		setContentView(v);
	}
	
	protected void onPause() {
		super.onPause();
		v.pause();
	}
	
	protected void onResume() {
		super.onResume();
		v.resume();
	}
	
	public class Background extends SurfaceView implements Runnable{

		Thread t = null;
		
		SurfaceHolder holder;
		Boolean check = false;
		
		public Background(Context context) {
			super(context);
			// TODO Auto-generated constructor stub
			holder = getHolder();
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while (check = true) {
				if(!holder.getSurface().isValid()){
					continue;
				}
				
				Canvas c = holder.lockCanvas();
				c.drawARGB(255, 51, 102, 255);
				c.drawBitmap(glove, x, y, null);
				holder.unlockCanvasAndPost(c);
				
			}
		}
		
		public void pause() {
			
			check = false;
			while(true) {
				try {
					t.join();
				} catch (InterruptedException e){
					e.printStackTrace();
				}
				break;
			}
			t =  null;
		}
		
		public void resume(){
			
			check = true;
			t = new Thread(this);
			t.start();
			
		}
	}

	@Override
	public boolean onTouch(View v, MotionEvent me) {
		// TODO Auto-generated method stub
		
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		switch(me.getAction()){
		case MotionEvent.ACTION_DOWN:
			x = me.getX();
			y = me.getY();
			break;
		case MotionEvent.ACTION_UP:
			x = me.getX();
			y = me.getY();
			break;
		case MotionEvent.ACTION_MOVE:
			x = me.getX();
			y = me.getY();
			break;
		}
		return false;
	}

}
