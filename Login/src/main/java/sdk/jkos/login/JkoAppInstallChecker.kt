package sdk.jkos.login

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager

internal class JkoAppInstallChecker {



    internal fun isPackageInstalled(packageName: String, context: Context): Boolean {
        return try {
            context.packageManager.getApplicationInfo(packageName, 0).enabled
        } catch (e: PackageManager.NameNotFoundException) {
            false
        }
    }
}