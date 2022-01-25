package com.example.appaskuseranswer.navigation

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.appaskuseranswer.AnswerActivity
import com.example.appaskuseranswer.R
import com.example.appaskuseranswer.databinding.FragmentQuestionBinding

class QuestionFragment : Fragment() {
    lateinit var binding: FragmentQuestionBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //바인딩 객체 획득
        binding = FragmentQuestionBinding.inflate(inflater, container, false)
        return binding.root

        var view =
            LayoutInflater.from(activity).inflate(R.layout.fragment_question, container, false)
        return view

        //알림창
        var quesAlert = activity?.let {
            AlertDialog.Builder(context).run {
                setTitle("1번 질문")
                setMessage("질문에 답변을 남기시겠어요? (답변은 하루에 하나의 질문만 가능합니다!)")
                setPositiveButton("작성", null)
                setNegativeButton("취소", null)
                show()
            }
        }

        //1번 질문 클릭 이벤트(미완성)
        binding.question1.setOnClickListener {
            quesAlert

            activity?.let {
                val intent = Intent(context, AnswerActivity::class.java)
            }
        }
    }
}


