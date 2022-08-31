package com.example.appaskuseranswer.dialog


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.DialogFragment
import com.example.appaskuseranswer.R
import com.example.appaskuseranswer.databinding.SettingRequestDialogBinding

class RequestDialog: DialogFragment() {

    private var _binding: SettingRequestDialogBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = SettingRequestDialogBinding.inflate(inflater, container, false)
        val view = binding.root

        ///취소 버튼(setting_request_dialog_cancel_btn) 누르면 팝업 종료
        view.findViewById<Button>(R.id.setting_request_dialog_cancel_btn).setOnClickListener {
            super.onDestroyView()
            _binding = null
        }

        return view

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null

    }


    }////



