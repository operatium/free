package other.base

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.AttributeSet
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup

import com.bumptech.glide.Glide
import com.trello.rxlifecycle2.components.support.RxFragment

open class BaseFragment : RxFragment() {

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        LogDebug.d("show", "onHiddenChanged $hidden")
    }

    override fun onGetLayoutInflater(savedInstanceState: Bundle?): LayoutInflater {
        LogDebug.d("show", "onGetLayoutInflater ")
        return super.onGetLayoutInflater(savedInstanceState)
    }

    override fun onInflate(context: Context?, attrs: AttributeSet, savedInstanceState: Bundle) {
        super.onInflate(context, attrs, savedInstanceState)
        LogDebug.d("show", "onInflate ")
    }

    override fun onAttachFragment(childFragment: Fragment?) {
        super.onAttachFragment(childFragment)
        LogDebug.d("show", "onAttachFragment ")
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        LogDebug.d("show", "onAttach ")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LogDebug.d("show", "onCreate ")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        LogDebug.d("show", "onCreateView ")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        LogDebug.d("show", "onViewCreated ")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        LogDebug.d("show", "onActivityCreated ")
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        LogDebug.d("show", "onViewStateRestored ")
    }

    override fun onStart() {
        super.onStart()
        LogDebug.d("show", "onStart ")
    }

    override fun onResume() {
        super.onResume()
        LogDebug.d("show", "onResume ")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        LogDebug.d("show", "onSaveInstanceState ")
    }

    override fun onMultiWindowModeChanged(isInMultiWindowMode: Boolean) {
        super.onMultiWindowModeChanged(isInMultiWindowMode)
        LogDebug.d("show", "onMultiWindowModeChanged ")
    }

    override fun onPictureInPictureModeChanged(isInPictureInPictureMode: Boolean) {
        super.onPictureInPictureModeChanged(isInPictureInPictureMode)
        LogDebug.d("show", "onPictureInPictureModeChanged ")
    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)
        LogDebug.d("show", "onConfigurationChanged ")
    }

    override fun onPause() {
        super.onPause()
        LogDebug.d("show", "onPause ")
    }

    override fun onStop() {
        super.onStop()
        LogDebug.d("show", "onStop ")
    }

    override fun onLowMemory() {
        super.onLowMemory()
        try {
            Glide.get(context!!).clearMemory()
        } catch (e: Exception) {
            LogDebug.e("201804020619",e.toString(),e)
        }
        LogDebug.d("show", "onLowMemory ")
    }


    override fun onDestroyView() {
        super.onDestroyView()
        LogDebug.d("show", "onDestroyView ")
    }

    override fun onDestroy() {
        super.onDestroy()
        LogDebug.d("show", "onDestroy ")
    }

    override fun onDetach() {
        super.onDetach()
        LogDebug.d("show", "onDetach ")
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        LogDebug.d("show", "onCreateOptionsMenu ")
    }

    override fun onPrepareOptionsMenu(menu: Menu?) {
        super.onPrepareOptionsMenu(menu)
        LogDebug.d("show", "onPrepareOptionsMenu ")
    }

    override fun onDestroyOptionsMenu() {
        super.onDestroyOptionsMenu()
        LogDebug.d("show", "onDestroyOptionsMenu ")
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        LogDebug.d("show", "onOptionsItemSelected ")
        return super.onOptionsItemSelected(item)
    }

    override fun onOptionsMenuClosed(menu: Menu?) {
        super.onOptionsMenuClosed(menu)
        LogDebug.d("show", "onOptionsMenuClosed ")
    }

    override fun onCreateContextMenu(menu: ContextMenu, v: View, menuInfo: ContextMenu.ContextMenuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo)
        LogDebug.d("show", "onCreateContextMenu ")
    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {
        LogDebug.d("show", "onContextItemSelected ")
        return super.onContextItemSelected(item)
    }
}
