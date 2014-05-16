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
		Log.v(TAG, "MyGroupView(Context context, AttributeSet attrs, int defStyle)" + this.getHeight()+"|"+this.getWidth());
		// TODO Auto-generated constructor stub
	}

	public MyGroupView(Context context, AttributeSet attrs) {
		super(context, attrs);
		mContext = context;
		setUpView();
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
		
		//���һ��TextView
		TextView mTextView = new TextView(mContext);
		mTextView.setText("helloworld");
		this.addView(mTextView);
		
		//���һ��ToggleButton
		ToggleButton mToggleButton = new ToggleButton(mContext);
		this.addView(mToggleButton);
		
		//���һ���Զ���view
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
		 Log.v(TAG, "the size of this ViewGroup is�� " + childCount) ;                            
		 Log.v(TAG, "------- onMeasure start") ;  
		 //��ȡ��ViewGroup��ʵ�ʳ��Ϳ�  �漰��MeasureSpec���ʹ��  
		 int specSize_Widht = MeasureSpec.getSize(widthMeasureSpec) ;  
		 int specSize_Heigth = MeasureSpec.getSize(heightMeasureSpec) ;       
		 Log.v(TAG, "------- specSize_Widht�� " + specSize_Widht+ " specSize_Heigth��" + specSize_Heigth) ;  	          
		 //���ñ�ViewGroup�Ŀ��  
		 setMeasuredDimension(specSize_Widht , specSize_Heigth) ;  
		 for(int i=0 ;i<childCount ; i++){  
			 View child = getChildAt(i) ; 
			 this.measureChild(child, widthMeasureSpec, heightMeasureSpec) ;   
			 //���߿��Ե���ViewGroup���෽��measure()����measureChildWithMargins()����  
		 }  

	}

	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		// TODO Auto-generated method stub
		 int childCount = getChildCount() ;         
		 int startLeft = 0 ;//����ÿ����View����ʼ�����   
		 int startTop = 10 ; //ÿ����View���븸��ͼ��λ�� �� ������Ϊ10px�� �� �������Ϊ android:margin=10px ;         
		 Log.v(TAG, "------- onLayout start ") ;  
		 for(int i=0 ;i<childCount ; i++){  
			 View child = getChildAt(i) ;   //���ÿ�����������  
			 child.layout(startLeft, startTop, startLeft+child.getMeasuredWidth(), startTop+child.getMeasuredHeight()) ;  
			 startLeft =startLeft+child.getMeasuredWidth() + 10;  //У׼startLeftֵ��View֮��ļ����Ϊ10px ;  
			 Log.v(TAG, "------- onLayout startLeft " +startLeft) ;  
		 }             

	}

}
