package com.example.appaskuseranswer.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appaskuseranswer.databinding.FragmentSettingBinding
import com.example.appaskuseranswer.databinding.SettingNoticeDialogBinding
import com.example.appaskuseranswer.db.model.Notice
import com.example.appaskuseranswer.db.viewmodel_notice.NoticeViewModel


class NoticeRecyclerViewAdapter(val context: Context, val itemList: MutableList<Notice>,
                                 val noticeViewModel: NoticeViewModel) : RecyclerView.Adapter<NoticeRecyclerViewAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: NoticeRecyclerViewAdapter, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
      return itemList.size
    }

    inner class Holder(val binding: FragmentSettingBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Notice) {


            binding.btnSettingNotice.setOnClickListener {
                noticeViewModel.getOneNotice(item.id)

            }
        }
    }


     }////