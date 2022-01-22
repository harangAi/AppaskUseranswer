package com.example.appaskuseranswer.db

import android.app.Application
import androidx.lifecycle.*
import androidx.room.Room
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

// 뷰모델은 DB에 직접 접근하지 않아야함. Repository 에서 데이터 통신.
class NoticeViewModel(application: Application) :AndroidViewModel(application) {

    private val db = Room.databaseBuilder(application, NoticeDatabase::class.java, "notice").allowMainThreadQueries().build()

    fun getAll() : LiveData<List<Notice>> {
        return db.noticeDao().getAll()
    }

    fun insert(notice: Notice) {
        db.noticeDao().insert(notice)
    }
}