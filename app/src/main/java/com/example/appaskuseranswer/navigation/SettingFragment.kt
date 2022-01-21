package com.example.appaskuseranswer.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.DialogFragment
import com.example.appaskuseranswer.dialog.NoticeDialog
import com.example.appaskuseranswer.R
import com.example.appaskuseranswer.dialog.AlarmDialog
import com.example.appaskuseranswer.dialog.RequestDialog


class SettingFragment : DialogFragment() {

    private val dialog = NoticeDialog()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view = LayoutInflater.from(activity).inflate(R.layout.fragment_setting, container, false)
        return view



    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //목록에서 공지사항버튼(btn_setting_notice)을 누르면 팝업
        view.findViewById<Button>(R.id.btn_setting_notice).setOnClickListener {
            val noticeDialog = NoticeDialog()
            noticeDialog.show(
                parentFragmentManager, "Notice"
            )
        }

        //목록에서 원하는 질문 의뢰하기 버튼(btn_setting_request)을 누르면 팝업
        view.findViewById<Button>(R.id.btn_setting_request).setOnClickListener {
            val requestDialog = RequestDialog()
            requestDialog.show(
                parentFragmentManager, "Request"
            )
        }

        //목록에서 알림설정 버튼(btn_setting_alarm)을 누르면 팝업
        view.findViewById<Button>(R.id.btn_setting_alarm).setOnClickListener {
            val alarmDialog = AlarmDialog()
            alarmDialog.show(
                parentFragmentManager, "Alarm"
            )
        }


    }

        }////
















