package other.base;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;

import com.bumptech.glide.Glide;
import com.trello.rxlifecycle2.android.ActivityEvent;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

/**
 * Created by java on 2017/10/20.
 */

public class BaseActivity extends RxAppCompatActivity {
    public static final int FULL_SCREEN_STYLE = 10;
    public static final int FULL_HIDE_ACTION_BAR_ONLY = 11;
    public static final int FULL_HIDE_ACTION_BAR_AND_STATUS_BAR = 12;
    public static final int FULL_HIDE_ACTION_BAR_ADD_STATUS_BAR_COLOR = 13;
    public static final int FULL_HIDE_ACTION_BAR_AND_STATUS_BAR_ADD_COLOR = 14;
    public static final int FULL_HIDE_ACTION_BAR_AND_STATUS_BAR_ADD_COLOR_BOTTOM = 15;
    private ActivityEvent currentLife;//当前生命周期

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            initWindowStyle(FULL_HIDE_ACTION_BAR_ADD_STATUS_BAR_COLOR, Color.parseColor("#33000000"));
        }catch (Exception e){
            LogDebug.e("201801310948",e.toString(),e);
        }
        LogDebug.d("show","Activity onCreate");
    }

    public void initWindowStyle(int style) {
        initWindowStyle(style, Color.TRANSPARENT);
    }

    public void initWindowStyle(int style, int colorRes) {
        switch (style) {
            case FULL_SCREEN_STYLE:
                if (Build.VERSION.SDK_INT >= 21) {
                    View decorView = getWindow().getDecorView();
                    int option = View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
                    decorView.setSystemUiVisibility(option);
                    getWindow().setNavigationBarColor(Color.TRANSPARENT);
                    getWindow().setStatusBarColor(colorRes);
                }
                break;
            case FULL_HIDE_ACTION_BAR_ONLY:
                if (Build.VERSION.SDK_INT >= 21) {
                    View decorView = getWindow().getDecorView();
                    int option = View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
                    decorView.setSystemUiVisibility(option);
                }
                break;
            case FULL_HIDE_ACTION_BAR_AND_STATUS_BAR:
                if (Build.VERSION.SDK_INT >= 21) {
                    View decorView = getWindow().getDecorView();
                    int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
                    decorView.setSystemUiVisibility(option);
                    getWindow().setNavigationBarColor(Color.TRANSPARENT);
                    getWindow().setStatusBarColor(colorRes);
                }
                break;
            case FULL_HIDE_ACTION_BAR_AND_STATUS_BAR_ADD_COLOR:
                if (Build.VERSION.SDK_INT >= 21) {
                    View decorView = getWindow().getDecorView();
                    int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
                    decorView.setSystemUiVisibility(option);
                    getWindow().setStatusBarColor(colorRes);
                }
                break;
            case FULL_HIDE_ACTION_BAR_ADD_STATUS_BAR_COLOR:
                if (Build.VERSION.SDK_INT >= 21) {
                    View decorView = getWindow().getDecorView();
                    int option = View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
                    decorView.setSystemUiVisibility(option);
                    getWindow().setStatusBarColor(colorRes);
                }
                break;
            case FULL_HIDE_ACTION_BAR_AND_STATUS_BAR_ADD_COLOR_BOTTOM:
                if (Build.VERSION.SDK_INT >= 21) {
                    View decorView = getWindow().getDecorView();
                    int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
                    decorView.setSystemUiVisibility(option);
                    getWindow().setStatusBarColor(Color.TRANSPARENT);
                }
                break;
        }
        if (getSupportActionBar() != null) getSupportActionBar().hide();
    }


    @Override
    protected void onResume() {
        super.onResume();
        LogDebug.d("show","Activity onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        currentLife = ActivityEvent.PAUSE;
        LogDebug.d("show","Activity onPause");
    }

    @Override
    protected void onStart() {
        super.onStart();
        currentLife = ActivityEvent.START;
        LogDebug.d("show", "Activity onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        LogDebug.d("show", "Activity onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        LogDebug.d("show","Activity onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogDebug.d("show","Activity onDestroy");
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        Glide.get(this).clearMemory();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getPointerCount() >1){
            return true;
        }
        return false;
    }

    public ActivityEvent getCurrentLife() {
        return currentLife;
    }

    public void setCurrentLife(ActivityEvent currentLife) {
        this.currentLife = currentLife;
    }
}
