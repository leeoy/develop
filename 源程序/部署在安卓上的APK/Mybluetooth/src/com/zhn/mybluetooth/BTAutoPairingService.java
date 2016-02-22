package com.zhn.mybluetooth;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**  */
public class BTAutoPairingService extends Service {

        private static final Object lock = new Object();
        private static boolean isRunning = false;
        private AutoPairing pairing;

        @Override
        public IBinder onBind(Intent intent) {
                // TODO Auto-generated method stub
                return null;
        }

        /**  */
        @Override
        public void onCreate() {
                synchronized (lock) {
                        isRunning = true;
                }
                pairing = new AutoPairing(this);
                pairing.init("0000");
        }

        @Override
        public int onStartCommand(Intent intent, int flags, int startId) {
                return START_STICKY;
        }

        @Override
        public void onDestroy() {
                synchronized (lock) {
                        isRunning = false;
                }
                pairing.unInit();
        }

        public static boolean isRunning() {
                return isRunning;
        }
}