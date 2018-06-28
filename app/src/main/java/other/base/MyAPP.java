package other.base;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.support.multidex.MultiDexApplication;
import android.util.Log;


import com.tencent.bugly.crashreport.CrashReport;

import other.fitscreen.PhoneInfo;
import v.activity.hongruan.FaceDB;


public class MyAPP extends MultiDexApplication {
    private final String TAG = this.getClass().toString();
    public FaceDB mFaceDB;
    public Uri mImage;


    @Override
    public void onCreate() {
        super.onCreate();
        try {
            //APP初始化+
            AppInfo.INSTANCE.init(this);
            CrashReport.initCrashReport(this);
            PhoneInfo.INSTANCE.init(this);
            try {
                int screenWidth = PhoneInfo.INSTANCE.getScreenWidth();
                int screenHeight = PhoneInfo.INSTANCE.getScreenHeight();
                CrashReport.putUserData(AppInfo.INSTANCE.getContext(), "windowSize"
                        , "screenWidth = " + screenWidth + " / screenHeight = " + screenHeight);
            } catch (Exception e) {
                LogDebug.e("201805161752", e.toString(), e);
            }
            mFaceDB = new FaceDB(this.getExternalCacheDir().getPath());
            mImage = null;
        } catch (Exception e) {
            LogDebug.e("201804041336", e.toString(), e);
        }
    }

    public void setCaptureImage(Uri uri) {
        mImage = uri;
    }

    public Uri getCaptureImage() {
        return mImage;
    }

    /**
     * @param path
     * @return
     */
    public static Bitmap decodeImage(String path) {
        Bitmap res;
        try {
            ExifInterface exif = new ExifInterface(path);
            int orientation = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);

            BitmapFactory.Options op = new BitmapFactory.Options();
            op.inSampleSize = 1;
            op.inJustDecodeBounds = false;
            //op.inMutable = true;
            res = BitmapFactory.decodeFile(path, op);
            //rotate and scale.
            Matrix matrix = new Matrix();

            if (orientation == ExifInterface.ORIENTATION_ROTATE_90) {
                matrix.postRotate(90);
            } else if (orientation == ExifInterface.ORIENTATION_ROTATE_180) {
                matrix.postRotate(180);
            } else if (orientation == ExifInterface.ORIENTATION_ROTATE_270) {
                matrix.postRotate(270);
            }

            Bitmap temp = Bitmap.createBitmap(res, 0, 0, res.getWidth(), res.getHeight(), matrix, true);
            Log.d("com.arcsoft", "check target Image:" + temp.getWidth() + "X" + temp.getHeight());

            if (!temp.equals(res)) {
                res.recycle();
            }
            return temp;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}