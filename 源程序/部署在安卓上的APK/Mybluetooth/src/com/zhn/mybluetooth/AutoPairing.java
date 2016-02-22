package com.zhn.mybluetooth;
import java.lang.reflect.Method;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.widget.Toast;

public class AutoPairing {

        private boolean autoPairing = true;
        private String pairingCode = "0000";
        private Context mContext;
        private BroadcastReceiver broadcastReceiver;
        private boolean debug = false;

        public AutoPairing(Context mContext) {
                this.mContext = mContext;
        }

        public void init(String pairingCode) {
                this.pairingCode = pairingCode;
                initBroadcast();
        }

        public void unInit() {
                this.pairingCode = "0000";
                uninitBroadcast();
        }

        public boolean setPin(BluetoothDevice btDevice, byte[] pin) {
                try {
                        Class<? extends BluetoothDevice> btClass = btDevice.getClass();
                        Method setPinRef = btClass
                                        .getDeclaredMethod("setPin", byte[].class);
                        Boolean ret = (Boolean) setPinRef.invoke(btDevice, pin);
                        return ret.booleanValue();
                } catch (SecurityException e) {
                } catch (IllegalArgumentException e) {
                } catch (Exception e) {
                }
                return false;
        }

        private void initBroadcast() {
                if (null == mContext)
                        return;
                broadcastReceiver = new BroadcastReceiver() {

                        @Override
                        public void onReceive(Context context, Intent intent) {
                                // TODO Auto-generated method stub

                                String action = intent.getAction();
                                BluetoothDevice device = intent
                                                .getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                                if ("android.bluetooth.device.action.PAIRING_REQUEST"
                                                .equals(action)) {
                                        if (!autoPairing)
                                                return;
                                        if (device == null)
                                                return;
                                        boolean ret;
                                        ret = setPin(device, pairingCode.getBytes());
                                        DBG("setPin: " + ret);

                                }
                        }

                };
                IntentFilter intentFilter = new IntentFilter();
                intentFilter
                                .addAction("android.bluetooth.device.action.PAIRING_REQUEST");
                mContext.registerReceiver(broadcastReceiver, intentFilter);
        }

        private void uninitBroadcast() {
                if (null == mContext)
                        return;
                if (broadcastReceiver != null)
                        mContext.unregisterReceiver(broadcastReceiver);
        }

        private void DBG(String msg) {
                if (!debug)
                        return;
                if (null == mContext)
                        return;
                Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
        }
}