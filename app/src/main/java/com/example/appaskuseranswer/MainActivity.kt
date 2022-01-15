package com.example.appaskuseranswer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.appaskuseranswer.navigation.DetailViewFragment
import com.example.appaskuseranswer.navigation.ListFragment
import com.example.appaskuseranswer.navigation.QuestionFragment
import com.example.appaskuseranswer.navigation.SettingFragment
import com.example.appaskuseranswer.R
import com.google.android.material.bottomnavigation.BottomNavigationView
//import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() , BottomNavigationView.OnNavigationItemSelectedListener{

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

     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_main)
//         bottom_navi.setOnNavigationItemSelectedListener(this)

     }



}//
