package com.zhn.mybluetooth;




import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Activity_index extends Activity {
	
	private static final String	TAG	= "Activity_index";

	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_index);
		Log.v(TAG, "onCreate");
		
		Button button_low = (Button) findViewById(R.id.low);
		/* ����button���¼���Ϣ */
		button_low.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v)
			{
				/* �½�һ��Intent���� */
				Intent intent = new Intent();
				/* ָ��intentҪ�������� */
				intent.setClass(Activity_index.this, MainActivity.class);
				/* ����һ���µ�Activity */
				startActivity(intent);
				/* �رյ�ǰ��Activity */
				Activity_index.this.finish();
			}
		});
		/******************************/
		Button button_mid = (Button) findViewById(R.id.mid);
		/* ����button���¼���Ϣ */
		button_mid.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v)
			{
				/* �½�һ��Intent���� */
				Intent intent1 = new Intent();
				
				
				/* ָ��intentҪ�������� */
				intent1.setClass(Activity_index.this, com.zhn.bluetooth.MainActivity.class);
				
				
				/* ����һ���µ�Activity */
				startActivity(intent1);
				
				
				/* �رյ�ǰ��Activity */
				Activity_index.this.finish();
			}
		});
		Button button_high = (Button) findViewById(R.id.high);
		/* ����button���¼���Ϣ */
		button_high.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v)
			{
				Intent intent1 = new Intent();
				/* ָ��intentҪ�������� */
				intent1.setClass(Activity_index.this, com.zhn.mybluetooth.AdvancedActivity.class);
				
				
				/* ����һ���µ�Activity */
				startActivity(intent1);
				
				
				/* �رյ�ǰ��Activity */
				Activity_index.this.finish();
			}
		});
	}

	public void onStart()
	{
		super.onStart();
		Log.v(TAG, "onStart");
	}
	
	public void onResume()
	{
		super.onResume();
		Log.v(TAG, "onResume");
	}
	
	public void onPause()
	{
		super.onPause();
		Log.v(TAG, "onPause");
	}
	
	public void onStop()
	{
		super.onStop();
		Log.v(TAG, "onStop");
	}

	public void onDestroy()
	{
		super.onDestroy();
		Log.v(TAG, "onDestroy");
	}

	public void onRestart()
	{
		super.onRestart();
		Log.v(TAG, "onReStart");
	}
}
