package com.zhn.mybluetooth;


import java.util.Date;

import com.zhn.bluetoothUtil.BluetoothTools;
import com.zhn.bluetoothUtil.TransmitBean;
import com.zhn.otherfunction.*;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import com.zhn.otherfunction.RingBroadcastReceiver;

public class AdvancedActivity extends Activity {
	 Button button_receive,button_share,button_back;
	  MyIntent ia = new MyIntent();  
	 private static final String TAG="RingToggle";
	 private AlarmManager mAlarmManager;
	 
		private TimePicker mTimePicker ;
		
		private int mTab;
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_advanced);
			
			button_receive=(Button)findViewById(R.id.receive);
			button_share=(Button)findViewById(R.id.share);
			button_back=(Button)findViewById(R.id.back6);
			button_receive.setOnClickListener(new Button.OnClickListener(){
				//  @SuppressLint("SdCardPath")
				public void onClick(View v){
				  //�Զ���android Intent�࣬
					  //�����ڻ�ȡ�������ļ���intent
					  //PDF,PPT,WORD,EXCEL,CHM,HTML,TEXT,AUDIO,VIDEO
					   
					  //����ʾ��:
					  //������У���������ΪPDF.apk����û��Ȩ�޷�������APK���asset��Դ�ļ�,�ֻ�����·��д��?
					  //Intent it = getPdfFileIntent("file:///android_asset/helphelp.pdf");
					   
					  //������Щ��OK
					 // Intent it = ia.getHtmlFileIntent("/mnt/sdcard/tutorial.html");//SD����Ŀ¼
					  //Intent it = getHtmlFileIntent("/sdcard/tutorial.html");//SD����Ŀ¼,����Ҳ����
					  //Intent it = getHtmlFileIntent("/system/etc/tutorial.html");//ϵͳ�ڲ���etcĿ¼
					  //Intent it = getPdfFileIntent("/system/etc/helphelp.pdf");
					 // Intent it = ia.getWordFileIntent("/mnt/sdcard/download/news.doc");
					  //Intent it = getExcelFileIntent("/mnt/sdcard/Book1.xls")
					  //Intent it = getPptFileIntent("/mnt/sdcard/download/Android_PPT.ppt");//SD����downloadĿ¼��
					  //Intent it = getVideoFileIntent("/mnt/sdcard/ice.avi");
					  //Intent it = getAudioFileIntent("/mnt/sdcard/ren.mp3");
					  //Intent it = getImageFileIntent("/mnt/sdcard/images/001041580.jpg");
					  Intent intent= new Intent();        
					    intent.setAction("android.intent.action.VIEW");    
					    Uri content_url = Uri.parse("http://192.168.44.73:8080/Mybluetooth/show_one?mac=3C:CB:7C:47:56:1F");   
					    intent.setData(content_url);  
					    startActivity(intent);

				/*	TransmitBean transmit = new TransmitBean();
					
					transmit.setFilename("news");
					transmit.setFilepath("/mnt/sdcard/download/news.txt");
					Intent sendDataIntent = new Intent(BluetoothTools.ACTION_DATA_TO_SERVICE);
					sendDataIntent.putExtra(BluetoothTools.DATA, transmit);
					sendBroadcast(sendDataIntent);

					*/
					 
					}
				
			});
			 
			button_share.setOnClickListener(new Button.OnClickListener(){

				@Override
				public void onClick(View v) {
					
					Intent tetherSettings = new Intent(); 
					tetherSettings.setClassName("com.android.settings", "com.android.settings.TetherSettings"); 
					startActivity(tetherSettings); 
				}
				
				
			});
			 
			button_back.setOnClickListener(new Button.OnClickListener() {
				public void onClick(View v)
				{
					/* �½�һ��Intent���� */
					Intent intent = new Intent();
					/* ָ��intentҪ�������� */
					intent.setClass(AdvancedActivity.this, Activity_index.class);
					/* ����һ���µ�Activity */
					startActivity(intent);
					/* �رյ�ǰ��Activity */
					AdvancedActivity.this.finish();
				}
			});
				
			
			
		}
		protected void vibrate()
		{
			Intent intent = new Intent(RingBroadcastReceiver.VIBRATE_CHANGED);
			if ( mTab == 0 )
			{
				intent.putExtra("checkedId", R.id.vibrate01);
			}
			else
			{
				intent.putExtra("checkedId", R.id.vibrate02);
			}
			PendingIntent alarmIntent = PendingIntent.getBroadcast(this, RingBroadcastReceiver.REQUEST_CODE, intent, 0);
			Log.e(TAG, "" + intent);
			mAlarmManager.set(AlarmManager.RTC_WAKEUP, getTime(), alarmIntent);
		}
		@SuppressWarnings("deprecation")
		private long getTime()
		{
			Date dateNow = new Date();
			long hour = mTimePicker.getCurrentHour() - dateNow.getHours();
			long min = mTimePicker.getCurrentMinute() - dateNow.getMinutes();
			long second = dateNow.getSeconds();
			return dateNow.getTime() + (hour * 60 + min) * 60 * 1000 - second * 1000;
		}
		
		@Override
		public boolean onCreateOptionsMenu(Menu menu) {
			// Inflate the menu; this adds items to the action bar if it is present.
			getMenuInflater().inflate(R.menu.main, menu);
			return true;
		}

}
