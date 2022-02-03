package com.example.appaskuseranswer.util

import androidx.recyclerview.widget.DiffUtil
import com.example.appaskuseranswer.db.model.Notice

class NoticeDiffUtil(val oldList: MutableList<Notice>, val newList: MutableList<Notice>):DiffUtil.Callback()  {

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }

}////