package com.fx.he;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class RectangleView extends View{
	private static String TAG = "RectangleView";
	private Paint mPaint = new Paint();

	public RectangleView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		Log.v(TAG, "RectangleView(Context context)" + this.getHeight()+"|"+this.getWidth());
	}
	

	public RectangleView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
		Log.v(TAG, "RectangleView(Context context, AttributeSet attrs, int defStyle)" + this.getHeight()+"|"+this.getWidth());
	}


	public RectangleView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		Log.v(TAG, "RectangleView(Context context, AttributeSet attrs)" + this.getHeight()+"|"+this.getWidth());
	}


	@Override
	protected void onLayout(boolean changed, int left, int top, int right,
			int bottom) {
		// TODO Auto-generated method stub
		super.onLayout(changed, left, top, right, bottom);
		Log.v(TAG, "onLayout" + this.getHeight()+"|"+this.getWidth());
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// TODO Auto-generated method stub
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		Log.v(TAG, "onMeasure" + this.getHeight()+"|"+this.getWidth());
	}


	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		mPaint.setColor(Color.BLUE);
		mPaint.setShader(new Shader());
		canvas.drawCircle(120, 90, 40, mPaint);
		canvas.drawText(TAG, 20, 20, mPaint);
	}
	

}
