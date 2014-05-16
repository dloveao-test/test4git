package com.fx.he;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MyGroupView extends ViewGroup{
	private static String TAG = "MyGroupView";
	private Context mContext;

	public MyGroupView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		mContext = context;
		mContext = context;
		Log.v(TAG, "MyGroupView(Context context, AttributeSet attrs, int defStyle)" + this.getHeight()+"|"+this.getWidth());
		// TODO Auto-generated constructor stub
	}

	public MyGroupView(Context context, AttributeSet attrs) {
		super(context, attrs);
		mContext = context;
		setUpView();
		Log.v(TAG, "MyGroupView(Context context, AttributeSet attrs)" + this.getHeight()+"|"+this.getWidth());
		// TODO Auto-generated constructor stub
	}

	public MyGroupView(Context context) {
		super(context);
		mContext = context;
		setUpView();
		Log.v(TAG, "MyGroupView(Context context)" + this.getHeight()+"|"+this.getWidth());
		// TODO Auto-generated constructor stub
	}

	private void setUpView() {
		// TODO Auto-generated method stub
		
		//添加一个TextView
		TextView mTextView = new TextView(mContext);
		mTextView.setText("helloworld");
		this.addView(mTextView);
		
		//添加一个ToggleButton
		ToggleButton mToggleButton = new ToggleButton(mContext);
		this.addView(mToggleButton);
		
		//添加一个自定义view
		RectangleView mRectangleView = new RectangleView(mContext);
		this.addView(mRectangleView);
				
	}

	@Override
	protected void dispatchDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.dispatchDraw(canvas);
	}

	@Override
	protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
		// TODO Auto-generated method stub
		return super.drawChild(canvas, child, drawingTime);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// TODO Auto-generated method stub
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		 int childCount = getChildCount() ;  
		 Log.v(TAG, "the size of this ViewGroup is： " + childCount) ;                            
		 Log.v(TAG, "------- onMeasure start") ;  
		 //获取该ViewGroup的实际长和宽  涉及到MeasureSpec类的使用  
		 int specSize_Widht = MeasureSpec.getSize(widthMeasureSpec) ;  
		 int specSize_Heigth = MeasureSpec.getSize(heightMeasureSpec) ;       
		 Log.v(TAG, "------- specSize_Widht： " + specSize_Widht+ " specSize_Heigth：" + specSize_Heigth) ;  	          
		 //设置本ViewGroup的宽高  
		 setMeasuredDimension(specSize_Widht , specSize_Heigth) ;  
		 for(int i=0 ;i<childCount ; i++){  
			 View child = getChildAt(i) ; 
			 this.measureChild(child, widthMeasureSpec, heightMeasureSpec) ;   
			 //或者可以调用ViewGroup父类方法measure()或者measureChildWithMargins()方法  
		 }  

	}

	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		// TODO Auto-generated method stub
		 int childCount = getChildCount() ;         
		 int startLeft = 0 ;//设置每个子View的起始横坐标   
		 int startTop = 10 ; //每个子View距离父视图的位置 ， 简单设置为10px吧 。 可以理解为 android:margin=10px ;         
		 Log.v(TAG, "------- onLayout start ") ;  
		 for(int i=0 ;i<childCount ; i++){  
			 View child = getChildAt(i) ;   //获得每个对象的引用  
			 child.layout(startLeft, startTop, startLeft+child.getMeasuredWidth(), startTop+child.getMeasuredHeight()) ;  
			 startLeft =startLeft+child.getMeasuredWidth() + 10;  //校准startLeft值，View之间的间距设为10px ;  
			 Log.v(TAG, "------- onLayout startLeft " +startLeft) ;  
		 }             

	}

}
