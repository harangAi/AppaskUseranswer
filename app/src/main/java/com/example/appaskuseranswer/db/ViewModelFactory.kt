package com.example.appaskuseranswer.db

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.appaskuseranswer.db.repository.NoticeRepository

class ViewModelFactory(private val noticeRepository: NoticeRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(NoticeRepository::class.java).newInstance(noticeRepository)
    }
}