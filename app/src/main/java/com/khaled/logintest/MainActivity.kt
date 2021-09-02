package com.khaled.logintest

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import sdk.jkos.login.JkoCore
import sdk.jkos.login.JkoLoginManager

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("xx", "mode" + JkoCore.isDebugMode())
        button_login.setOnClickListener {
            JkoCore.setDebugMode(true)
            JkoLoginManager().startToLogin(this)
        }

        checkData()
    }

    private fun checkData(){
        val intent = this.intent
        val dataString = intent.dataString
        if(dataString == "jkoslogintest://test1234"){
            JkoLoginManager().authTokenParser(this,dataString)
        }
    }

}
