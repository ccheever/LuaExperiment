package com.ccheever.luaexperiment

import android.app.Activity
import android.os.Bundle
import android.widget.RelativeLayout
import android.widget.TextView

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Example of a call to a native method
        val lo = RelativeLayout(this)
        val lp = RelativeLayout.LayoutParams(400, 400)
        lo.layoutParams = lp

        val tv = TextView(this)
        val tvlp = RelativeLayout.LayoutParams(200, 200)

        tv.layoutParams = tvlp
        tv.text = stringFromJNI()

        setContentView(tv)


    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {

        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }
}
