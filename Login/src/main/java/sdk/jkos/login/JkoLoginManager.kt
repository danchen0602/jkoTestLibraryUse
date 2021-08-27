package sdk.jkos.login

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner

class JkoLoginManager(private val  lifecycleOwner: LifecycleOwner) {

    fun startToLogin(fragment: Fragment){
        startDeeplink(fragment.context)
    }
    fun startToLogin(activity: Activity){
        startDeeplink(activity)
    }

    private fun startDeeplink(context: Context?){
        val uri = Uri.parse("jkos://test123")
        val it = Intent(Intent.ACTION_VIEW, uri)
        it.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        context?.startActivity(it)
    }
}