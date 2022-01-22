package com.example.appaskuseranswer.db

import androidx.lifecycle.LiveData

// 앱에서 사용하는 데이터와 그 데이터 통신을 하는 역할
class NoticeRepository(private val noticeDao: NoticeDao) {

    val getAll : LiveData<List<Notice>> = noticeDao.getAll()

    suspend fun insert(notice: Notice) {
        noticeDao.insert(notice)
    }

}