package other.utils;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.regex.Pattern;

/**
 * Created by luodi on 2017/6/22.
 * 通用方法收集归纳
 */

public class BaseUtils {

    public static int dp2px(Context context, int dp){
        double px =  dp * context.getResources().getDisplayMetrics().density+0.5;
        return Double.valueOf(px).intValue();
    }

    /**
     * 屏幕截图
     * @param activity
     * @return
     */
    public static Bitmap takeScreenShot(Activity activity) {
        long millis = System.currentTimeMillis();
        View view = activity.getWindow().getDecorView();
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();

        Bitmap bp = Bitmap.createBitmap(view.getDrawingCache(), 0, 0, view.getMeasuredWidth(),
                view.getMeasuredHeight());

        view.setDrawingCacheEnabled(false);
        view.destroyDrawingCache();
        Log.i("CommonUtil","耗时: " + (System.currentTimeMillis() - millis));
        return bp;
    }
    /**
     * bitmap转为base64
     * @param bitmap
     * @return
     */
    public static String bitmapToBase64(Bitmap bitmap) {

        String result = null;
        ByteArrayOutputStream baos = null;
        try {
            if (bitmap != null) {
                baos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);

                baos.flush();
                baos.close();

                byte[] bitmapBytes = baos.toByteArray();
                result = Base64.encodeToString(bitmapBytes, Base64.DEFAULT);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (baos != null) {
                    baos.flush();
                    baos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * base64转为bitmap
     * @param base64Data
     * @return
     */
    public static Bitmap base64ToBitmap(String base64Data) {
        byte[] bytes = Base64.decode(base64Data, Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
    }
    /**
     * bitmap转化成数组
     * @param bmp
     * @return
     */
    public static byte[] convertBitmap2ByteArray(Bitmap bmp) {
        if (bmp == null) return null;
        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.PNG, 100, baos);
        return baos.toByteArray();
    }

    /**
     * 将byte数组转化成bitmap对象
     * @param byteArray
     * @return
     */
    public static Bitmap covertByteArray2Bitmap(byte[] byteArray) {
        if (byteArray == null) return null;
        return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
    }


    /**
     * 获取cpu核心数
     * @return
     */
    public static int getCpuCoreNum() {
        //Private Class to display only CPU devices in the directory listing
        class CpuFilter implements FileFilter {
            @Override
            public boolean accept(File pathname) {
                //Check if filename is "cpu", followed by a single digit number
                if(Pattern.matches("cpu[0-9]", pathname.getName())) {
                    return true;
                }
                return false;
            }
        }
        try {
            //Get directory containing CPU info
            File dir = new File("/sys/devices/system/cpu/");
            //Filter to only list the devices we care about
            File[] files = dir.listFiles(new CpuFilter());
            //Return the number of cores (virtual CPU devices)
            return files.length;
        } catch(Exception e) {
            //Default to return 1 core
            return 1;
        }
    }

    /**
     * 获取设备总RAM数
     * @return
     */
    public static int getTotalMemInfo() {
        String dir = "/proc/meminfo";
        try {
            FileReader fr = new FileReader(dir);
            BufferedReader br = new BufferedReader(fr, 2048);
            String memoryLine = br.readLine();
            String subMemoryLine = memoryLine.substring(memoryLine.indexOf("MemTotal:"));
            br.close();
            long meminfo = Integer.parseInt(subMemoryLine.replaceAll("\\D+", "")) * 1024l;
            return (int) Math.ceil(meminfo / 1024f / 1024f / 1024f);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 检测是否有emoji表情
     *
     * @param source
     * @return
     */
    public static boolean containsEmoji(String source) {
        int len = source.length();
        for (int i = 0; i < len; i++) {
            char codePoint = source.charAt(i);
            if (!isEmojiCharacter(codePoint)) { //如果不能匹配,则该字符是Emoji表情
                return true;
            }
        }
        return false;
    }

    /**
     * 判断是否是Emoji
     *
     * @param codePoint 比较的单个字符
     * @return
     */
    private static boolean isEmojiCharacter(char codePoint) {
        return (codePoint == 0x0) || (codePoint == 0x9) || (codePoint == 0xA) ||
                (codePoint == 0xD) || ((codePoint >= 0x20) && (codePoint <= 0xD7FF)) ||
                ((codePoint >= 0xE000) && (codePoint <= 0xFFFD)) || ((codePoint >= 0x10000)
                && (codePoint <= 0x10FFFF));
    }


    /**
     * 字符串拼接，避免通过 + 连接导致产生大量String对象
     * @param obj 用户设置的需要拼接的字符串内容
     * @return 拼接后的长字符串String对象
     */
    public static String getLongStr(Object... obj) {
        StringBuilder builder = new StringBuilder();
        for (Object o : obj) {
            builder.append(o);
        }
        return builder.toString();
    }

    /**
     * int值伪随机数生成
     * @param min 生成随机数的最小值
     * @param max 生成随机数的最大值
     * @return 生成的int随机数
     */
    public static int generateRandom(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    /**
     * 获取设备id，具备较好的唯一性
     * 需要"android.permission.READ_PHONE_STATE"权限
     * @param context
     * @return
     */
    public static String getDeviceCode(Context context) {
        if (context == null) return "";
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        return tm.getDeviceId();
    }

    /**
     * 获取app版本号
     * @param context
     * @return
     */
    public static String getAppVersion(Context context) {
        if (context == null) return "";
        try {
            PackageManager packageManager = context.getPackageManager();
            String packagename = context.getPackageName();
            PackageInfo packageInfo = packageManager.getPackageInfo(packagename, 0);
            return packageInfo.versionName;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 获取设备型号
     * @return
     */
    public static String getDeviceModel() {
        return android.os.Build.MODEL;
    }

    /**
     * 将bitmap转换成byte数组
     * @param bm bitmap对象
     * @return byte数组
     */
    public static byte[] getByteInfoByBitmap(Bitmap bm) {
        if (bm == null) return null;
        try {
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bm.compress(Bitmap.CompressFormat.PNG, 100, stream);
            byte[] bytes = stream.toByteArray();
            return bytes;
        } catch (Exception e) {

        }
       return null;
    }

    /**
     * 获取当前时间时间戳
     * @return
     */
    public static long getTimeStamp() {
        return System.currentTimeMillis();
    }

    /**
     * 根据日期格式及时间戳获取格式化日期
     * @param format 格式规则
     * @param timestamp 时间戳
     * @return
     */
    public static String getTimeByFormat(String format, long timestamp) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date = new Date(timestamp);
        return sdf.format(date);
    }
}
