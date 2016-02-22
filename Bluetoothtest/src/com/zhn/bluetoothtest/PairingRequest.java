package com.zhn.bluetoothtest;
 
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
 
public class PairingRequest extends BroadcastReceiver {
    String strPsw = "0000";
    final String ACTION_PAIRING_REQUEST = "android.bluetooth.device.action.PAIRING_REQUEST";
    static BluetoothDevice remoteDevice = null;
 
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(ACTION_PAIRING_REQUEST)) {
 
            BluetoothDevice device = intent
                    .getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
            if (device.getBondState() != BluetoothDevice.BOND_BONDED) {
                try {
                    ClsUtils.setPin(device.getClass(), device, strPsw); // 鎵嬫満鍜岃摑鐗欓噰闆嗗櫒閰嶅
                    // ClsUtils.cancelPairingUserInput(device.getClass(),
                    // device); //涓�埇璋冪敤涓嶆垚鍔燂紝鍓嶈█閲岄潰璁茶В杩囦簡
                    Toast.makeText(context, "閰嶅淇℃伅" + device.getName(), 5000)
                            .show();
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    Toast.makeText(context, "璇锋眰杩炴帴閿欒...", 1000).show();
                }
            }
            // */
            // pair(device.getAddress(),strPsw);
        }
    }
}