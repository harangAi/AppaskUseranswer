package com.example.appaskuseranswer.dialog


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.DialogFragment
import com.example.appaskuseranswer.R
import com.example.appaskuseranswer.databinding.SettingNoticeDialogBinding
import com.example.appaskuseranswer.db.Notice
import io.realm.Realm

class NoticeDialog: DialogFragment() {

    private var _binding: SettingNoticeDialogBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = SettingNoticeDialogBinding.inflate(inflater, container, false)
        val view = binding.root

        //데이터를 저장
        val realm = Realm.getDefaultInstance()
        realm.executeTransaction {
            with(it.createObject(Notice::class.java)) {
                this.title = "공지사항 테스트 중입니다(제목)"
                this.content = "공지사항 테스트 중입니다(내용)"
                this.date = "공지사항 테스트 중입니다(날짜)"
            }
        }

        ///공지사항 확인 버튼(setting_notice_dialog_ok_btn) 누르면 팝업 종료
        view.findViewById<Button>(R.id.setting_notice_dialog_ok_btn).setOnClickListener {
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



