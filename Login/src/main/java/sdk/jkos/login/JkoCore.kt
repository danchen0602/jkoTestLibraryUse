package sdk.jkos.login

object JkoCore {

    private var debugMode = false

    fun setDebugMode(isDebugMode: Boolean) {
        this.debugMode = isDebugMode
    }

    fun isDebugMode(): Boolean {
        return this.debugMode
    }

}