package com.example.appaskuseranswer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.appaskuseranswer.fragment.ListFragment
import com.example.appaskuseranswer.fragment.QuestionFragment
import com.example.appaskuseranswer.fragment.SettingFragment
import com.google.android.material.bottomnavigation.BottomNavigationView



class MainActivity : AppCompatActivity() {

    private lateinit var settingFragment: SettingFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initFragment()

        var bnv_main = findViewById(R.id.bottom_navi) as BottomNavigationView

        bnv_main.run { setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.page_question -> { //오늘의 질문
                    var questionFragment = QuestionFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, questionFragment).commit()

                }

                R.id.page_list -> { //질문기록
                    var listFragment = ListFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, listFragment).commit()

                }

                R.id.page_setting -> { //설정
                    var settingFragment = SettingFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, settingFragment).commit()

                }

            }
            true

        }

        selectedItemId = R.id.page_question //오늘의 질문

        }


    }




    private fun initFragment() {
        val questionFragment = QuestionFragment()
        commitFragment(questionFragment)
    }

    private fun commitFragment(fragment: Fragment) {
        var questionFragment = QuestionFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, questionFragment).commit()
    }

}////
