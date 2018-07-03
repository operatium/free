package v.activity.gushi

import android.os.Bundle

import com.yyx.R

import other.base.BaseActivity
import v.fragment.kxian.KLineFragment

/**
 * Created by opera on 2018/7/3.
 */

class GuShiHangQingActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gushihangqing)
        val translation = supportFragmentManager.beginTransaction()
        translation.add(R.id.fragment8,KLineFragment(),"KXianFragment")
        translation.commitAllowingStateLoss()
    }
}
