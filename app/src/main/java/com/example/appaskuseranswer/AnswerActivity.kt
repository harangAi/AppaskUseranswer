package com.example.appaskuseranswer

import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class AnswerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_answer)
    }

    val eventHandler = object : DialogInterface.OnClickListener {
        override fun onClick(p0: DialogInterface?, p1: Int) {
            when {
                p1 == DialogInterface.BUTTON_POSITIVE -> {
                    Log.d("yes", "positive button click")
                    finish() //앱종료가 됨 (여기에선 앱종료가 아닌 이전 페이지(QuestionFragment)로 이동하는 것으로 수정할 것.)
                }
                p1 == DialogInterface.BUTTON_NEGATIVE -> {
                    Log.d("no", "negative button click")
                    null
                }
            }
        }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        when (keyCode) {
            KeyEvent.KEYCODE_BACK -> {
                Log.d("back", "뒤로가기 버튼 누름")
                AlertDialog.Builder(this).run {
                    setMessage("글 작성을 취소하시나요?")
                    setPositiveButton("예", eventHandler)
                    setNegativeButton("아니오", eventHandler)
                    show()
                }
            }
        }
        return super.onKeyDown(keyCode, event)
    }
}