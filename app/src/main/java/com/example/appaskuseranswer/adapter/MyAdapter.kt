package com.example.appaskuseranswer.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appaskuseranswer.databinding.SettingNoticeDialogBinding
import com.example.appaskuseranswer.model.Notice

class MyAdapter: RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private var noticeList = emptyList<Notice>()

    class MyViewHolder(val binding: SettingNoticeDialogBinding) : RecyclerView.ViewHolder(binding.root)

    //어떤 xml으로 뷰 홀더를 생성할지 지정
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = SettingNoticeDialogBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = noticeList[position]
        val currentId = currentItem.id
        val currentTitle = currentItem.title.toString()
        val currentContents = currentItem.contents.toString()
        val currentDate = currentItem.date.toString()

        holder.binding.settingNoticeDialogTitle.text = currentTitle
        holder.binding.settingNoticeDialogContents.text = currentContents
        holder.binding.settingNoticeDialogDate.text = currentDate


    }

    //뷰 홀더의 개수 리턴
    override fun getItemCount(): Int {
        return noticeList.size
    }

    //공지사항 리스트 갱신
    fun setData(notice: List<Notice>) {
        noticeList = notice
        notifyDataSetChanged()
    }

}////