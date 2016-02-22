package com.zhn.mybluetooth;



import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    Button button_start,button_visible,button_back;
    BluetoothAdapter btadp = BluetoothAdapter.getDefaultAdapter();
    
   
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		button_start=(Button)findViewById(R.id.start);
		button_visible=(Button)findViewById(R.id.visible);
		button_back=(Button)findViewById(R.id.back);
		if (btadp.getState() == BluetoothAdapter.STATE_OFF) {
			button_start.setText("������");
		} else if (btadp.getState() == BluetoothAdapter.STATE_ON) {
			button_start.setText("�ر�����");
		}
		
		button_start.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View v){
				if (v == button_start) {
					if (btadp.getState() == BluetoothAdapter.STATE_OFF) {
						btadp.enable();
						button_start.setText("�ر�����");
					} else if (btadp.getState() == BluetoothAdapter.STATE_ON) {
						btadp.disable();
						button_start.setText("������");
					}
				 
				}
			}
		});
		 
		button_visible.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View v) {
				Intent visible = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
				visible.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 200);
				startActivity(visible);
				
			}
			
			
		});
		 
		button_back.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v)
			{
				/* �½�һ��Intent���� */
				Intent intent = new Intent();
				/* ָ��intentҪ�������� */
				intent.setClass(MainActivity.this, Activity_index.class);
				/* ����һ���µ�Activity */
				startActivity(intent);
				/* �رյ�ǰ��Activity */
				MainActivity.this.finish();
			}
		});
			
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
