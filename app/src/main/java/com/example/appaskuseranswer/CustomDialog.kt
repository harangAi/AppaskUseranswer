package com.example.appaskuseranswer

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import androidx.fragment.app.DialogFragment
import com.example.appaskuseranswer.databinding.ActivityMainBinding
import com.example.appaskuseranswer.databinding.SettingNoticeDialogBinding

class CustomDialog: DialogFragment() {

    private var _binding: SettingNoticeDialogBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = SettingNoticeDialogBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }




}//