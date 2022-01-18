package com.example.appaskuseranswer.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.appaskuseranswer.R
import com.example.appaskuseranswer.databinding.ActivityMainBinding


class SettingFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        var view = LayoutInflater.from(activity).inflate(R.layout.fragment_setting, container, false)
        return view
    }



        }
















