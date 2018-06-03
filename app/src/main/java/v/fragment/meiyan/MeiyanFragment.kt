package v.fragment.meiyan

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.yyx.R
import kotlinx.android.synthetic.main.meiyan_fragment_main.*

import other.base.BaseFragment
import other.base.GlideApp
import other.base.LogDebug
import java.io.File

/**
 * Created by Administrator on 2018/6/3.
 */

class MeiyanFragment : BaseFragment() {
    private var path: String? = null

    companion object {

        fun newInstance(path: String): MeiyanFragment {
            val fragment = MeiyanFragment()
            fragment.path = path
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        try {
            return inflater.inflate(R.layout.meiyan_fragment_main, container,false)
        } catch (e: Exception) {
            LogDebug.e("201806032202",e.toString(),e)
            return null
        }
    }

    override fun onStart() {
        super.onStart()
        try {
            GlideApp.with(image3).load(Uri.fromFile(File(path))).into(image3)
            addClickEventOrRemove(true)
        }catch (e : Exception){
            LogDebug.e("201806032155",e.toString(),e)
        }
    }

    override fun onStop() {
        super.onStop()
        addClickEventOrRemove(false)
    }

    fun addClickEventOrRemove(boolean: Boolean){
        if (boolean){
            back3.setOnClickListener{
                activity?.finish()
            }
        }else{
            back3.setOnClickListener(null)
        }
    }

}
