package v.fragment.paizhao;

import android.net.Uri;
import android.os.Bundle;

import com.jph.takephoto.app.TakePhoto;
import com.jph.takephoto.app.TakePhotoFragment;
import com.jph.takephoto.model.TResult;

import java.io.File;

import c.app.FileControl;
import other.base.LogDebug;

/**
 * Created by Administrator on 2018/6/3.
 */

public class TakeFragment extends TakePhotoFragment {
    private TakeOutCallback callback;

    public static TakeFragment newInstance(TakeOutCallback callback1){
        TakeFragment fragment = new TakeFragment();
        fragment.callback = callback1;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            TakePhoto takePhoto = getTakePhoto();
            File file = new File(FileControl.getFullPath(getActivity(), FileControl.getDir_Public_Temp(), true, true)
                    , System.currentTimeMillis() + ".png");
            takePhoto.onPickFromCapture(Uri.fromFile(file));
            LogDebug.d("show", "take uri = " + file.getAbsolutePath());
        } catch (Exception e) {
            LogDebug.e("201806032157", e.toString(), e);
        }
    }

    @Override
    public void takeSuccess(TResult result) {
        try {
            if (callback != null)
                callback.endFunction(result.getImage().getOriginalPath());
            callback = null;
        } catch (Exception e) {
            LogDebug.e("201806032156", e.toString(), e);
        }
    }

    @Override
    public void takeFail(TResult result, String msg) {
        super.takeFail(result, msg);
    }

    @Override
    public void takeCancel() {
        super.takeCancel();
    }
}