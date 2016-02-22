package com.zhn.bluetoothtest;
 
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.util.Log;
public class ClsUtils 
{ 
  public static BluetoothDevice remoteDevice=null;
     /** 
      * 涓庤澶囬厤瀵�鍙傝�婧愮爜锛歱latform/packages/apps/Settings.git 
      * /Settings/src/com/android/settings/bluetooth/CachedBluetoothDevice.java 
      */
     @SuppressWarnings("unchecked")
  static public boolean createBond(@SuppressWarnings("rawtypes") Class btClass, BluetoothDevice btDevice) 
             throws Exception 
     { 
         Method createBondMethod = btClass.getMethod("createBond"); 
         Boolean returnValue = (Boolean) createBondMethod.invoke(btDevice); 
         return returnValue.booleanValue(); 
     } 
    
     /** 
      * 涓庤澶囪В闄ら厤瀵�鍙傝�婧愮爜锛歱latform/packages/apps/Settings.git 
      * /Settings/src/com/android/settings/bluetooth/CachedBluetoothDevice.java 
      */
     @SuppressWarnings("unchecked")
  static public boolean removeBond(Class btClass, BluetoothDevice btDevice) 
             throws Exception 
     { 
         Method removeBondMethod = btClass.getMethod("removeBond"); 
         Boolean returnValue = (Boolean) removeBondMethod.invoke(btDevice); 
         return returnValue.booleanValue(); 
     } 
    
     @SuppressWarnings("unchecked")
  static public boolean setPin(Class btClass, BluetoothDevice btDevice, 
             String str) throws Exception 
     { 
         try
         { 
             Method removeBondMethod = btClass.getDeclaredMethod("setPin", 
                     new Class[] 
                     {byte[].class}); 
             Boolean returnValue = (Boolean) removeBondMethod.invoke(btDevice, 
                     new Object[] 
                     {str.getBytes()}); 
             Log.d("returnValue", "setPin is success " +btDevice.getAddress()+ returnValue.booleanValue());
         } 
         catch (SecurityException e) 
         { 
             // throw new RuntimeException(e.getMessage()); 
             e.printStackTrace(); 
         } 
         catch (IllegalArgumentException e) 
         { 
             // throw new RuntimeException(e.getMessage()); 
             e.printStackTrace(); 
         } 
         catch (Exception e) 
         { 
             // TODO Auto-generated catch block 
             e.printStackTrace(); 
         } 
         return true; 
    
     } 
    
     // 鍙栨秷鐢ㄦ埛杈撳叆 
     @SuppressWarnings("unchecked")
  static public boolean cancelPairingUserInput(Class btClass, 
             BluetoothDevice device) 
    
     throws Exception 
     { 
         Method createBondMethod = btClass.getMethod("cancelPairingUserInput"); 
         // cancelBondProcess() 
         Boolean returnValue = (Boolean) createBondMethod.invoke(device); 
         Log.d("returnValue", "cancelPairingUserInput is success " + returnValue.booleanValue());
         return returnValue.booleanValue(); 
     } 
    
     // 鍙栨秷閰嶅 
     @SuppressWarnings("unchecked")
  static public boolean cancelBondProcess(Class btClass, 
             BluetoothDevice device) 
    
     throws Exception 
     { 
         Method createBondMethod = btClass.getMethod("cancelBondProcess"); 
         Boolean returnValue = (Boolean) createBondMethod.invoke(device); 
         return returnValue.booleanValue(); 
     } 
    
     /** 
      *  
      * @param clsShow 
      */
     @SuppressWarnings("unchecked")
  static public void printAllInform(Class clsShow) 
     { 
         try
         { 
             // 鍙栧緱鎵�湁鏂规硶 
             Method[] hideMethod = clsShow.getMethods(); 
             int i = 0; 
             for (; i < hideMethod.length; i++) 
             { 
                 //Log.e("method name", hideMethod.getName() + ";and the i is:"
                   //      + i); 
             } 
             // 鍙栧緱鎵�湁甯搁噺 
             Field[] allFields = clsShow.getFields(); 
             for (i = 0; i < allFields.length; i++) 
             { 
                 //Log.e("Field name", allFields.getName()); 
             } 
         } 
         catch (SecurityException e) 
         { 
             // throw new RuntimeException(e.getMessage()); 
             e.printStackTrace(); 
         } 
         catch (IllegalArgumentException e) 
         { 
             // throw new RuntimeException(e.getMessage()); 
             e.printStackTrace(); 
         } 
         catch (Exception e) 
         { 
             // TODO Auto-generated catch block 
             e.printStackTrace(); 
         } 
     } 
}