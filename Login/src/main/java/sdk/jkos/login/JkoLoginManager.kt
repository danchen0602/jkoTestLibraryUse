package sdk.jkos.login

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner

class JkoLoginManager() {

    fun startToLogin(fragment: Fragment) {
        startDeeplink(fragment.context)
    }

    fun startToLogin(activity: Activity) {
        startDeeplink(activity)
    }

    private fun startDeeplink(context: Context?) {
        if (context == null) {
            return
        }

        var jkoAppId = "com.jkos.app"
        if (JkoCore.isDebugMode()) {
            //jkoAppId = "com.jkos.app.debug"
        }
        if (JkoAppInstallChecker().isPackageInstalled(jkoAppId, context)) {
            val uri = Uri.parse("jkos://getAuthFromExternal")
            val it = Intent(Intent.ACTION_VIEW, uri)
            it.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            context.startActivity(it)
        } else {
            // app is not install
            sendDeepLinkInfoAndGoInstall(context)
        }
    }

    // TODO : call api and intent to google play
    private fun sendDeepLinkInfoAndGoInstall(context: Context){
        val deviceId = Settings.Secure.getString(context.contentResolver,Settings.Secure.ANDROID_ID)

    }

    fun authTokenParser(context: Context?,authToken: String?): String? {
        if (authToken == null || context == null) {
            return null
        }
        Toast.makeText(context,"Auth getter!!",Toast.LENGTH_SHORT).show()

        return "auth"

    }


}