package c.app

import android.content.Context
import android.content.Intent
import v.activity.SeePicActivity
import v.activity.hongruan.HongRuanFaceActivity
import v.activity.jiankangzhilu.SeeVideoActivity
import v.activity.opencv.FaceDetectionOpenCVActivity

/**
 * 管理APP的路由功能
 */

object RouteControl {

    //跳转查看图片
    fun ToSeePic(context: Context) {
        context.startActivity(Intent(context, SeePicActivity::class.java))
    }

    //跳转opencv实现摄像头预览 人脸识别
    fun ToOpencv(context: Context) {
        context.startActivity(Intent(context, FaceDetectionOpenCVActivity::class.java))
    }

    //跳转健康之路
    fun ToJiankangzhilu(context: Context) {
        context.startActivity(Intent(context, SeeVideoActivity::class.java))
    }

    //跳转虹软的人脸识别
    fun ToHongRuan(context: Context) {
        context.startActivity(Intent(context, HongRuanFaceActivity::class.java))
    }
}