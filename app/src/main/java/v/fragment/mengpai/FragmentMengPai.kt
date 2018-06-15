package v.fragment.mengpai

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.SurfaceTexture
import android.hardware.camera2.CameraAccessException
import android.hardware.camera2.CameraCaptureSession
import android.hardware.camera2.CameraCharacteristics
import android.hardware.camera2.CameraDevice
import android.hardware.camera2.CameraManager
import android.hardware.camera2.params.StreamConfigurationMap
import android.os.Build
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.view.LayoutInflater
import android.view.Surface
import android.view.TextureView
import android.view.View
import android.view.ViewGroup

import com.yyx.R
import kotlinx.android.synthetic.main.fragment_mengpai_main.*

import java.util.Arrays

import other.base.BaseFragment

/**
 * Created by opera on 2018/6/15.
 */

class FragmentMengPai : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_mengpai_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        takebutton5.setOnClickListener{
            takePic()
        }
    }

    override fun onResume() {
        super.onResume()
        cameraView5.onResume(activity)
    }

    override fun onPause() {
        cameraView5.onPause()
        super.onPause()
    }

    fun takePic() {
        cameraView5.takePicture()
    }
}