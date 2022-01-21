package com.example.appaskuseranswer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.appaskuseranswer.navigation.ListFragment
import com.example.appaskuseranswer.navigation.QuestionFragment
import com.example.appaskuseranswer.navigation.SettingFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var settingFragment: SettingFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initFragment()

        var bnv_main = findViewById(R.id.bottom_navi) as BottomNavigationView

        bnv_main.run { setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.page_question -> {
                    var questionFragment = QuestionFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, questionFragment).commit()

                }

                R.id.page_list -> {
                    var listFragment = ListFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, listFragment).commit()

                }

                R.id.page_setting -> {
                    var settingFragment = SettingFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, settingFragment).commit()

                }

            }
            true

        }

        selectedItemId = R.id.page_question

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
