package com.example.appaskuseranswer.repository

import com.example.appaskuseranswer.data.NoticeDao
import com.example.appaskuseranswer.model.Notice
import kotlinx.coroutines.flow.Flow

//앱에서 사용하는 데이터와 그 데이트 통신을 하는 역할
class NoticeRepository(private val noticeDao: NoticeDao) {

    val getAll: Flow<List<Notice>> = noticeDao.getAll()

    suspend fun addNotice(notice: Notice) {
        noticeDao.addNotice(notice)
    }

    fun getTitle() {
        noticeDao.getTitle()
    }

    fun getContents() {
        noticeDao.getContents()
    }

    fun getDate() {
        noticeDao.getDate()
    }
}