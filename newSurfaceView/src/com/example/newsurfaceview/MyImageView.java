package com.example.newsurfaceview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.Display;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;


public class MyImageView extends ImageView {
	  private Drawable image;
//	  private float scaleFactor = 1.0f;
	  static float scaleFactor = 1.0f;
	  private ScaleGestureDetector scaleGestureDetector;
	  
	  //for drag
		private int _xDelta;
		private int _yDelta;

	  public MyImageView(Context context) {
	    super(context);
	    image = context.getResources().getDrawable(R.drawable.office);
	    setFocusable(true);
//	    image.setBounds(0, 0, image.getIntrinsicWidth(),
//	        image.getIntrinsicHeight());
	    

	    image.setBounds(0, 0, (int)MainActivity.width,
	    		(int)MainActivity.height-90);
	    
	    scaleGestureDetector = new ScaleGestureDetector(context,
	        new ScaleListener());
	  }

	  @Override
	  protected void onDraw(Canvas canvas) {
	    super.onDraw(canvas);
	    // Set the image bounderies
	    canvas.save();
	    canvas.scale(scaleFactor, scaleFactor);
	    image.draw(canvas);
	    canvas.restore();
	  }

	  @Override
	  public boolean onTouchEvent(MotionEvent event) {
	    scaleGestureDetector.onTouchEvent(event);
	    
	    //for drag
		final int X = (int) event.getRawX();
		final int Y = (int) event.getRawY();
	      switch (event.getAction() & MotionEvent.ACTION_MASK) {
			case MotionEvent.ACTION_DOWN:
				RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams) this.getLayoutParams();
				_xDelta = X - lParams.leftMargin;
				_yDelta = Y - lParams.topMargin;
				break;
			case MotionEvent.ACTION_UP:
				break;
			case MotionEvent.ACTION_POINTER_DOWN:
				break;
			case MotionEvent.ACTION_POINTER_UP:
				break;
			case MotionEvent.ACTION_MOVE:
				RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this
						.getLayoutParams();
				layoutParams.leftMargin = X - _xDelta;
				layoutParams.topMargin = Y - _yDelta;
//				layoutParams.rightMargin = -250;
//				layoutParams.bottomMargin = -250;
				
				layoutParams.rightMargin = -( X - _xDelta);
				layoutParams.bottomMargin = -(Y - _yDelta);
				
				this.setLayoutParams(layoutParams);
				break;
			}

	    invalidate();
	    return true;
	  }

	  private class ScaleListener extends
	      ScaleGestureDetector.SimpleOnScaleGestureListener {
	    @Override
	    public boolean onScale(ScaleGestureDetector detector) {
	      scaleFactor *= detector.getScaleFactor();

	      // don't let the object get too small or too large.
	      scaleFactor = Math.max(0.1f, Math.min(scaleFactor, 5.0f));
	      
	     
	      invalidate();
	      return true;
	    }
	  }
	} 
