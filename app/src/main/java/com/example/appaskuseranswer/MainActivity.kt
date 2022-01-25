package com.example.appaskuseranswer

import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.appaskuseranswer.navigation.ListFragment
import com.example.appaskuseranswer.navigation.QuestionFragment
import com.example.appaskuseranswer.navigation.SettingFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

//import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    lateinit var main1 : QuestionFragment

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        when (p0.itemId) {
            R.id.page_question -> {
                var questionFragment = QuestionFragment()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, questionFragment).commit()
                return true
            }

            R.id.page_list -> {
                var listFragment = ListFragment()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, listFragment).commit()
                return true
            }

            R.id.page_setting -> {
                var settingFragment = SettingFragment()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, settingFragment).commit()
                return true
            }
        }
        var questionFragment = QuestionFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, questionFragment).commit()
        return false
    }

    //이전 버튼 클릭 함수
    val exitEvent = object : DialogInterface.OnClickListener {
        override fun onClick(p0: DialogInterface?, p1: Int) {
            when {
                p1 == DialogInterface.BUTTON_POSITIVE -> {
                    Log.d("yes", "positive button click")
                    finish() //앱종료가 됨
                }
                p1 == DialogInterface.BUTTON_NEGATIVE -> {
                    Log.d("no", "negative button click")
                    null
                }
            }
        }
    }

    //이전 버튼 클릭 이벤트
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        when (keyCode) {
            KeyEvent.KEYCODE_BACK -> {
                Log.d("back", "뒤로가기 버튼 누름")
                AlertDialog.Builder(this).run {
                    setMessage("앱을 종료하시겠습니까?")
                    setPositiveButton("예", exitEvent)
                    setNegativeButton("아니오", exitEvent)
                    show()
                }
            }
        }
        return super.onKeyDown(keyCode, event)
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//         bottom_navi.setOnNavigationItemSelectedListener(this)

    }


}//
