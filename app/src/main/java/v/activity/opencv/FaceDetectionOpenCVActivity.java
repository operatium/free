package v.activity.opencv;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.os.Bundle;
import android.support.v7.content.res.AppCompatResources;
import android.view.SurfaceView;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.yyx.R;

import org.opencv.android.BaseLoaderCallback;
import org.opencv.android.CameraBridgeViewBase;
import org.opencv.android.JavaCameraView;
import org.opencv.android.LoaderCallbackInterface;
import org.opencv.android.OpenCVLoader;
import org.opencv.android.Utils;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;

import java.util.ArrayList;

import other.base.BaseActivity;
import other.base.GlideApp;
import other.base.LogDebug;

public class FaceDetectionOpenCVActivity extends BaseActivity implements CameraBridgeViewBase.CvCameraViewListener2 {
    private ObjectDetector mFaceDetector;

    private static String CAMERAIMAGENAME = "image.jpg";
    private JavaCameraView javaCameraView;
    private ImageView imageButton2;
    private TextView textView;
    private Bitmap bitmap;
    private Bitmap rectBitmap;
    private Bitmap resizeBitmap;
    private Toast toast;
    private static String strLibraryName = "opencv_java3"; // 不需要添加前缀 libopencv_java3

    static {
        try {
            System.loadLibrary(strLibraryName);
        } catch (Exception e) {
            LogDebug.e("201806091157", e.toString(), e);
        }
    }

    private BaseLoaderCallback baseLoaderCallback = new BaseLoaderCallback(this) {
        @Override
        public void onManagerConnected(int status) {
            switch (status) {
                case LoaderCallbackInterface.SUCCESS: {
                    LogDebug.d("show", "OpenCV loaded successfully");

                    //加载人脸检测xml
                    mFaceDetector = new ObjectDetector(FaceDetectionOpenCVActivity.this
                            , R.raw.lbpcascade_frontalface
                            , 6, 0.2F, 0.2F
                            , new Scalar(255, 100, 100, 255));
                    //enable camera
                    javaCameraView.enableView();
                }
                break;
                default: {
                    super.onManagerConnected(status);
                }
                break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_face_detection_opencv);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        textView = findViewById(R.id.tv_face);
        javaCameraView = findViewById(R.id.iv_face);
        javaCameraView.setVisibility(SurfaceView.VISIBLE);
        javaCameraView.setCvCameraViewListener(this);
        imageButton2 = findViewById(R.id.iv_face2);
        getBeauty();
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (!OpenCVLoader.initDebug()) {
            OpenCVLoader.initAsync(OpenCVLoader.OPENCV_VERSION, this, baseLoaderCallback);
        } else {
            baseLoaderCallback.onManagerConnected(LoaderCallbackInterface.SUCCESS);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (javaCameraView != null)
            javaCameraView.disableView();
    }

    /**
     * 点击添加照片事件
     *
     * @param v
     */
    public void onClick(View v) {

        int bt_id = v.getId();
        switch (bt_id) {
            case R.id.addPic:
                // 添加照片
                // 打开本地相册
                Intent intent1 = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent1, 101);
                break;

            case R.id.takePhoto:
//                // 拍照
//                // 打开本地相机
//                Intent intent2 = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
//                Uri imageUri = Uri.fromFile(new File(Environment.getExternalStorageDirectory(), CAMERAIMAGENAME));
//                intent2.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
//                startActivityForResult(intent2, 102);
                javaCameraView.disableView();
                if (javaCameraView.getCameraIndex() == CameraBridgeViewBase.CAMERA_ID_FRONT)
                    javaCameraView.setCameraIndex(JavaCameraView.CAMERA_ID_BACK);
                else
                    javaCameraView.setCameraIndex(JavaCameraView.CAMERA_ID_FRONT);
                javaCameraView.enableView();
                break;

            case R.id.back:
                this.finish();
                break;

            default:
                break;
        }

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // 加判断 不选择照片或者不拍照时不闪退
        //Log.e("data", String.valueOf(data));
        //if (data == null)
        //return;

        bitmap = null;
        switch (requestCode) {
            // 选择图片库的图片
            case 101:
                if (resultCode == RESULT_OK) {
                    try {
                        Uri uri = data.getData();
                        bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                break;

            // 表示调用本地照相机拍照
            case 102:
                if (resultCode == RESULT_OK) {
                    //Bundle bundle = data.getExtras();
                    //bm = (Bitmap) bundle.get("data");
                    bitmap = BitmapFactory.decodeFile(Environment.getExternalStorageDirectory() + "/" + CAMERAIMAGENAME);

                }
                break;
            default:
                break;
        }
        // 将照片剪裁 bitmap将被释放重新赋值
        int ibWidth = javaCameraView.getWidth();
        int ibHeight = javaCameraView.getHeight();
        try {
            GlideApp.with(this).load(rectBitmap).override(ibWidth, ibHeight).into(imageButton2);
        } catch (Exception e) {
            LogDebug.e("201806081746", e.toString(), e);
        }

        LogDebug.d("bitmap", String.valueOf(bitmap));

        if (bitmap == null) {
            toast = Toast.makeText(FaceDetectionOpenCVActivity.this, "未选择图像", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }


        // 识别图片 并画框
        detectFace();


    }

    private void detectFace() {
        try {
            // bitmapToMat
            Mat toMat = new Mat();
            Utils.bitmapToMat(bitmap, toMat);
            Mat copyMat = new Mat();
            toMat.copyTo(copyMat); // 复制

            // togray
            Mat gray = new Mat();
            Imgproc.cvtColor(toMat, gray, Imgproc.COLOR_RGBA2GRAY);

            MatOfRect mRect = new MatOfRect();
            Rect[] object = mFaceDetector.detectObjectImage(gray, mRect);

            LogDebug.d("objectLength", object.length + "");


            int maxRectArea = 0 * 0;
            Rect maxRect = null;

            int facenum = 0;
            // Draw a bounding box around each face.
            for (Rect rect : object) {
                Imgproc.rectangle(
                        toMat,
                        new Point(rect.x, rect.y),
                        new Point(rect.x + rect.width, rect.y + rect.height),
                        new Scalar(255, 0, 0), 3);
                ++facenum;
                // 找出最大的面积
                int tmp = rect.width * rect.height;
                if (tmp >= maxRectArea) {
                    maxRectArea = tmp;
                    maxRect = rect;
                }
            }

            rectBitmap = null;
            if (facenum != 0) {
                // 剪切最大的头像
                LogDebug.d("剪切的长宽", String.format("高:%s,宽:%s", maxRect.width, maxRect.height));
                Rect rect = new Rect(maxRect.x, maxRect.y, maxRect.width, maxRect.height);
                Mat rectMat = new Mat(copyMat, rect);  // 从原始图像拿
                rectBitmap = Bitmap.createBitmap(rectMat.cols(), rectMat.rows(), Bitmap.Config.ARGB_8888);
                Utils.matToBitmap(rectMat, rectBitmap);
            }

            textView.setText(String.format("检测到%1$d个人脸", facenum));
            Utils.matToBitmap(toMat, bitmap);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onCameraViewStarted(int width, int height) {

    }

    @Override
    public void onCameraViewStopped() {

    }

    private Mat mRgba, mGray = new Mat(), beauty;
    private MatOfRect mObject = new MatOfRect();
    private ArrayList<Mat> beautyList = new ArrayList<>();

    @Override
    public Mat onCameraFrame(CameraBridgeViewBase.CvCameraViewFrame inputFrame) {
        mRgba = inputFrame.rgba();
        mGray = inputFrame.gray();
// 检测人脸
        Rect[] object = mFaceDetector.detectObject(mRgba, mObject);
        if (object.length > 0)
            LogDebug.d("show", "detectObject = " + object.length);
        if (object != null && object.length > 0) {
            for (Rect rect : object) {
                //检测到人脸矩形
                //矩形标识
                Imgproc.rectangle(mRgba, rect.tl(), rect.br(), mFaceDetector.getRectColor(), 3);
                beauty = beautyList.get(0);
                addBeauty(Double.valueOf(rect.tl().y).intValue(),Double.valueOf(rect.tl().x).intValue());
            }
        }
        //拍照一帧数据回调
//        if(onPhotoTakenListener != null){
//            onPhotoTakenListener.onPhotoTaken(mRgba);
//        }
        return mRgba;
    }

    /**
     * 添加宠萌效果
     *
     * @param offsetX x坐标偏移量
     * @param offsetY y坐标偏移量
     */
    private void addBeauty(int offsetX, int offsetY) {
        offsetX -= 200;//高度校正
        if (offsetX < 0) {
            offsetX = 0;
        }
        for (int x = 0; x < beauty.rows(); x++) {
            for (int y = 0; y < beauty.cols(); y++) {
                double[] array = beauty.get(x, y);
                if (array[0] != 0) {//过滤全黑像素
                    mRgba.put(x + offsetX, y + offsetY, array);
                }
            }
        }
    }

    /**
     * 获取宠萌妆饰list集合
     */
    private void getBeauty() {
        Drawable drawable1 = AppCompatResources.getDrawable(this, R.drawable.owl);
        Bitmap bitmap1 = ((BitmapDrawable) drawable1).getBitmap();
        Mat beauty1 = new Mat();
        Utils.bitmapToMat(bitmap1, beauty1);
        beautyList.add(beauty1);
    }
}

