package com.example.newsurfaceview;


import android.app.Activity;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends Activity {

	private int _xDelta;
	private int _yDelta;
	RelativeLayout rootPanel;
	
	static float width;
	static float height;
	static float height_actionbar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_main);
		
		Display display = getWindowManager().getDefaultDisplay();
		width = display.getWidth(); // ((display.getWidth()*20)/100)
		height = display.getHeight();// ((display.getHeight()*30)/100)

		
//		SurfaceView surfaceView = ...;  // use any SurfaceView you want
		SurfaceView surfaceView = new MySurfaceView(this);
		surfaceView.setZOrderOnTop(true);
		surfaceView.getHolder().setFormat(PixelFormat.TRANSPARENT);

		// Setup your ImageView
		ImageView bgImagePanel = new MyImageView(this);
		

//		bgImagePanel.setImageResource(R.drawable.office); // use any Bitmap or BitmapDrawable you want


//		bgImagePanel.setScaleType(ScaleType.FIT_XY);
		
//		Display display = getWindowManager().getDefaultDisplay();
//		int width = display.getWidth(); // ((display.getWidth()*20)/100)
//		int height = display.getHeight();// ((display.getHeight()*30)/100)
//		RelativeLayout.LayoutParams parms = new RelativeLayout.LayoutParams(30,30);
//		bgImagePanel.setLayoutParams(parms);
		
//		android:layout_alignParentLeft="true"
//			     android:layout_centerVertical="true"
		     

//		bgImagePanel.se.setFitToScreen(true);
//		bgImagePanel.setScaleType(ScaleType.FIT_CENTER);
		// Use a RelativeLayout to overlap both SurfaceView and ImageView
		RelativeLayout.LayoutParams fillParentLayout = new RelativeLayout.LayoutParams(
		    RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
		
		
		
//		RelativeLayout rootPanel = new RelativeLayout(this);
		rootPanel = new RelativeLayout(this);

		rootPanel.setLayoutParams(fillParentLayout);

		rootPanel.addView(surfaceView, fillParentLayout); 
		rootPanel.addView(bgImagePanel, fillParentLayout); 
		
		setContentView(rootPanel);
		
//		bgImagePanel.setOnTouchListener(this);
	}

	
	
}
