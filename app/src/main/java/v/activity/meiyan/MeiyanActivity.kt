package v.activity.meiyan

import android.os.Bundle
import com.yyx.R

import other.base.BaseActivity
import other.base.LogDebug
import v.fragment.meiyan.MeiyanFragment
import v.fragment.paizhao.TakeFragment
import v.fragment.paizhao.TakeOutCallback

/**
 * Created by Administrator on 2018/6/3.
 */

class MeiyanActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.meiyan_activity_main)
        GotoTake()
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onStop() {
        super.onStop()
    }

    fun GotoTake() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.meiyanroot4, TakeFragment.newInstance(object : TakeOutCallback {
            override fun endFunction(path: String?) {
                GotoMeiyan(path ?: "")
            }
        }), "TakeFragment")
        transaction.commitAllowingStateLoss()
    }

    fun GotoMeiyan(path: String) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.meiyanroot4, MeiyanFragment.newInstance(path), "MeiyanFragment")
        transaction.commitAllowingStateLoss()
    }
}
