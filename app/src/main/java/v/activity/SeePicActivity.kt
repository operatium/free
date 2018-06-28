package v.activity

import android.os.Bundle

import com.yyx.R

import other.base.BaseActivity
import android.content.Intent
import kotlinx.android.synthetic.main.activity_showfragment.*
import android.R.attr.path
import android.graphics.BitmapFactory
import android.graphics.Bitmap
import android.provider.MediaStore
import android.R.attr.data
import android.graphics.Color


/**
 * Created by opera on 2018/6/28.
 */

class SeePicActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_showfragment)
        see6.setBackgroundColor(Color.BLACK)
    }

    override fun onStart() {
        super.onStart()
        select6.setOnClickListener {
            val intent = Intent(
                    Intent.ACTION_PICK,
                    android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(intent, 10000)
        }
    }

    override fun onStop() {
        super.onStop()
        select6.setOnClickListener(null)
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode){
            10000->{
                try {
                    val selectedImage = data?.data //获取系统返回的照片的Uri
                    see6.setImageURI(selectedImage)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
            else ->{
            }
        }
    }
}