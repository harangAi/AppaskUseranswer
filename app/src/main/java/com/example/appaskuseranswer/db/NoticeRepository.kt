package com.example.appaskuseranswer.db

import android.app.Application
import android.content.Context
import androidx.lifecycle.LiveData
import java.lang.Exception

// 앱에서 사용하는 데이터와 그 데이터 통신을 하는 역할
class NoticeRepository(application: Application) {

    private val noticeDatabase = NoticeDatabase.getInstance(application)
    private val noticeDao : NoticeDao = noticeDatabase!!.noticeDao()
    private val notices : LiveData<List<Notice>> = noticeDao.getAll()

    fun getAll() : LiveData<List<Notice>> {
        return notices
    }

    fun insert (notice: Notice) {
        try {
            val thread = Thread(Runnable {
                noticeDao.insert(notice)
            })
            thread.start()
        } catch (e : Exception) {e.printStackTrace()}
    }


}////