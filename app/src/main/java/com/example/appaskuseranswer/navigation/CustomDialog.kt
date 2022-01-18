package com.example.appaskuseranswer.navigation

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import com.example.appaskuseranswer.R
import kotlinx.android.synthetic.main.fragment_setting.*


class CustomDialog(context: Context) : Dialog(context) {

    private val layout = R.layout.setting_notice_dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout)
        //init()
    }

  /*  private fun init() {
        btn_setting_notice.setOnClickListener(this)
    }*/

    fun onClick(v:View) {
        when(v.id) {
            R.id.btn_setting_notice -> {
                dismiss()
            }
        }
    }

}
