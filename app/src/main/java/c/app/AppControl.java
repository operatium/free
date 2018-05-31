package c.app;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import other.base.BaseActivity;
import other.base.LogDebug;
import other.utils.FileUtils;

import static android.content.Context.TELEPHONY_SERVICE;

/**
 * 1. 文件夹管理FileControl 创建目录结构
 */
public class AppControl {


    //APP设备唯一码
    public static String DeviceKey(Context context,String dir, String key) {
        String DeviceKey = FileUtils.readCache(context, dir, key);
        if (DeviceKey == null || DeviceKey.length() < 10) {
            try {
                TelephonyManager TelephonyMgr = (TelephonyManager) context.getSystemService(TELEPHONY_SERVICE);
                String szImei = TelephonyMgr.getDeviceId();
                String m_szDevIDShort = "35" + //we make this look like a valid IMEI
                        Build.BOARD.length() % 10 +
                        Build.BRAND.length() % 10 +
                        Build.CPU_ABI.length() % 10 +
                        Build.DEVICE.length() % 10 +
                        Build.DISPLAY.length() % 10 +
                        Build.HOST.length() % 10 +
                        Build.ID.length() % 10 +
                        Build.MANUFACTURER.length() % 10 +
                        Build.MODEL.length() % 10 +
                        Build.PRODUCT.length() % 10 +
                        Build.TAGS.length() % 10 +
                        Build.TYPE.length() % 10 +
                        Build.USER.length() % 10; //13 digits
                String m_szAndroidID = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
                WifiManager wm = (WifiManager) context.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                String m_szWLANMAC = wm.getConnectionInfo().getMacAddress();
                String m_szBTMAC = "";
                try {
                    BluetoothAdapter m_BluetoothAdapter; // Local Bluetooth adapter
                    m_BluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
                    if (m_BluetoothAdapter != null)
                        m_szBTMAC = m_BluetoothAdapter.getAddress();
                } catch (Exception e) {
                    LogDebug.e("201805041157",e.toString(),e);
                }
                String m_szLongID = szImei + m_szDevIDShort
                        + m_szAndroidID + m_szWLANMAC + m_szBTMAC;
// compute md5
                MessageDigest m = null;
                try {
                    m = MessageDigest.getInstance("MD5");
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }
                m.update(m_szLongID.getBytes(), 0, m_szLongID.length());
// get md5 bytes
                byte p_md5Data[] = m.digest();
// create a hex string
                String m_szUniqueID = new String();
                for (int i = 0; i < p_md5Data.length; i++) {
                    int b = (0xFF & p_md5Data[i]);
// if it is a single digit, make sure it have 0 in front (proper padding)
                    if (b <= 0xF)
                        m_szUniqueID += "0";
// add number to string
                    m_szUniqueID += Integer.toHexString(b);
                }   // hex string to uppercase
                m_szUniqueID = m_szUniqueID.toUpperCase();
                DeviceKey = m_szUniqueID;
                FileUtils.writeCache(context, dir, key, DeviceKey);
            }catch (Exception e){
                LogDebug.e("201805161534",e.toString(),e);
                DeviceKey = "tongyongkey";
            }
        }
        return DeviceKey;
    }

    //退出
    public static void AppExit(BaseActivity activity) {
        try {
            activity.finish();
            System.exit(0);
        } catch (Exception e) {
            LogDebug.e("201804231759",e.toString(),e);
        }
    }

}
