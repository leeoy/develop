package com.zhn.bluetoothtest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cn.bluetooth.R;
 
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ToggleButton;
public class Bluetooth1 extends Activity {
    /** Called when the activity is first created. */
     Button btnSearch, btnDis, btnExit; 
     ToggleButton tbtnSwitch; 
     ListView lvBTDevices; 
     ArrayAdapter<String> adtDevices; 
     List<String> lstDevices = new ArrayList<String>(); 
     BluetoothAdapter btAdapt; 
     public static BluetoothSocket btSocket; 
     @Override
     public void onCreate(Bundle savedInstanceState) { 
         super.onCreate(savedInstanceState); 
         setContentView(R.layout.main); 
         // Button 璁剧疆 
         btnSearch = (Button) this.findViewById(R.id.btnSearch); 
         btnSearch.setOnClickListener(new ClickEvent()); 
         btnExit = (Button) this.findViewById(R.id.btnExit); 
         btnExit.setOnClickListener(new ClickEvent()); 
         btnDis = (Button) this.findViewById(R.id.btnDis); 
         btnDis.setOnClickListener(new ClickEvent()); 
   
         // ToogleButton璁剧疆 
         tbtnSwitch = (ToggleButton) this.findViewById(R.id.tbtnSwitch); 
         tbtnSwitch.setOnClickListener(new ClickEvent()); 
   
         // ListView鍙婂叾鏁版嵁婧�閫傞厤鍣�
         lvBTDevices = (ListView) this.findViewById(R.id.lvDevices); 
         adtDevices = new ArrayAdapter<String>(this, 
                 android.R.layout.simple_list_item_1, lstDevices); 
         lvBTDevices.setAdapter(adtDevices); 
         lvBTDevices.setOnItemClickListener(new ItemClickEvent()); 
   
         btAdapt = BluetoothAdapter.getDefaultAdapter();// 鍒濆鍖栨湰鏈鸿摑鐗欏姛鑳�
   
         // ======================================================== 
         // modified by wiley 
         /*
          * if (btAdapt.getState() == BluetoothAdapter.STATE_OFF)// 璇诲彇钃濈墮鐘舵�骞舵樉绀�
          * tbtnSwitch.setChecked(false); else if (btAdapt.getState() ==
          * BluetoothAdapter.STATE_ON) tbtnSwitch.setChecked(true);
          */
         if (btAdapt.isEnabled()) { 
             tbtnSwitch.setChecked(false); 
         } else { 
             tbtnSwitch.setChecked(true); 
         } 
         // ============================================================ 
         // 娉ㄥ唽Receiver鏉ヨ幏鍙栬摑鐗欒澶囩浉鍏崇殑缁撴灉 
         IntentFilter intent = new IntentFilter(); 
         intent.addAction(BluetoothDevice.ACTION_FOUND);// 鐢˙roadcastReceiver鏉ュ彇寰楁悳绱㈢粨鏋�
         intent.addAction(BluetoothDevice.ACTION_BOND_STATE_CHANGED); 
         intent.addAction(BluetoothAdapter.ACTION_SCAN_MODE_CHANGED); 
         intent.addAction(BluetoothAdapter.ACTION_STATE_CHANGED); 
         registerReceiver(searchDevices, intent); 
     } 
   
     private final BroadcastReceiver searchDevices = new BroadcastReceiver() {   
         @Override
   public void onReceive(Context context, Intent intent) {      
           
             String action = intent.getAction(); 
             Bundle b = intent.getExtras(); 
             Object[] lstName = b.keySet().toArray(); 
   
             // 鏄剧ず鎵�湁鏀跺埌鐨勬秷鎭強鍏剁粏鑺�
             for (int i = 0; i < lstName.length; i++) { 
                 String keyName = lstName.toString(); 
                 Log.e(keyName, String.valueOf(b.get(keyName))); 
             } 
             BluetoothDevice device = null; 
             // 鎼滅储璁惧鏃讹紝鍙栧緱璁惧鐨凪AC鍦板潃 
             if (BluetoothDevice.ACTION_FOUND.equals(action)) { 
                 device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE); 
                 if (device.getBondState() == BluetoothDevice.BOND_NONE) { 
                     String str = "           鏈厤瀵箌" + device.getName() + "|"
                             + device.getAddress(); 
                     if (lstDevices.indexOf(str) == -1)// 闃叉閲嶅娣诲姞 
                         lstDevices.add(str); // 鑾峰彇璁惧鍚嶇О鍜宮ac鍦板潃 
                     adtDevices.notifyDataSetChanged(); 
                 } 
             }else if(BluetoothDevice.ACTION_BOND_STATE_CHANGED.equals(action)){ 
                 device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE); 
                  
                 switch (device.getBondState()) { 
                 case BluetoothDevice.BOND_BONDING: 
                     Log.d("BlueToothTestActivity", "姝ｅ湪閰嶅......"); 
                     break; 
                 case BluetoothDevice.BOND_BONDED: 
                     Log.d("BlueToothTestActivity", "瀹屾垚閰嶅"); 
                     //connect(device);//杩炴帴璁惧 
                     break; 
                 case BluetoothDevice.BOND_NONE: 
                     Log.d("BlueToothTestActivity", "鍙栨秷閰嶅"); 
                 default: 
                     break; 
                 } 
             } 
               
         } 
     }; 
   
     @Override
     protected void onDestroy() { 
         this.unregisterReceiver(searchDevices); 
         super.onDestroy(); 
         android.os.Process.killProcess(android.os.Process.myPid()); 
     } 
   
     class ItemClickEvent implements AdapterView.OnItemClickListener { 
   
         @Override
         public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, 
                 long arg3) { 
             if(btAdapt.isDiscovering())btAdapt.cancelDiscovery(); 
             String str = lstDevices.get(arg2); 
             String[] values = str.split("\\|"); 
             String address = values[2]; 
             Log.e("address", values[2]);             
             BluetoothDevice btDev = btAdapt.getRemoteDevice(address); 
             try { 
                 Boolean returnValue = false; 
                 if (btDev.getBondState() == BluetoothDevice.BOND_NONE) { 
                     Toast.makeText(Bluetooth1.this, "杩滅▼璁惧鍙戦�钃濈墮閰嶅璇锋眰", 5000).show(); 
                     //杩欓噷鍙渶瑕乧reateBond灏辫浜�
                  ClsUtils.createBond(btDev.getClass(), btDev);   
                 }else if(btDev.getBondState() == BluetoothDevice.BOND_BONDED){ 
                     Toast.makeText(Bluetooth1.this, btDev.getBondState()+" ....姝ｅ湪杩炴帴..", 1000).show(); 
                 } 
             } catch (Exception e) { 
                 e.printStackTrace(); 
             } 
         } 
     } 
     class ClickEvent implements View.OnClickListener { 
         @Override
         public void onClick(View v) { 
             if (v == btnSearch)// 鎼滅储钃濈墮璁惧锛屽湪BroadcastReceiver鏄剧ず缁撴灉 
             { 
                 if (btAdapt.getState() == BluetoothAdapter.STATE_OFF) {// 濡傛灉钃濈墮杩樻病寮�惎 
                     Toast.makeText(Bluetooth1.this, "璇峰厛鎵撳紑钃濈墮", 1000) 
                             .show(); 
                     return; 
                 } 
                 if (btAdapt.isDiscovering()) 
                     btAdapt.cancelDiscovery(); 
                 lstDevices.clear(); 
                 Object[] lstDevice = btAdapt.getBondedDevices().toArray(); 
                 for (int i = 0; i < lstDevice.length; i++) { 
                     BluetoothDevice device = (BluetoothDevice) lstDevice[i]; 
                     String str = " 宸查厤瀵箌" + device.getName() + "|"
                             + device.getAddress(); 
                     lstDevices.add(str); // 鑾峰彇璁惧鍚嶇О鍜宮ac鍦板潃 
                     adtDevices.notifyDataSetChanged(); 
                 } 
                 setTitle("鏈満锛" + btAdapt.getAddress()); 
                 btAdapt.startDiscovery(); 
             } else if (v == tbtnSwitch) {// 鏈満钃濈墮鍚姩/鍏抽棴 
                 if (tbtnSwitch.isChecked() == false) 
                     btAdapt.enable(); 
   
                 else if (tbtnSwitch.isChecked() == true) 
                     btAdapt.disable(); 
                 
             } else if (v == btnDis)// 鏈満鍙互琚悳绱�
             { 
                 Intent discoverableIntent = new Intent( 
                         BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE); 
                 discoverableIntent.putExtra( 
                         BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 300); 
                 startActivity(discoverableIntent); 
             } else if (v == btnExit) { 
                 try { 
                     if (btSocket != null) 
                         btSocket.close(); 
                 } catch (IOException e) { 
                     e.printStackTrace(); 
                 } 
                 Bluetooth1.this.finish(); 
             } 
         } 
     } 
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
   
     
}