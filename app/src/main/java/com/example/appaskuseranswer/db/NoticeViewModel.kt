package com.example.appaskuseranswer.db


import android.app.Application
import androidx.databinding.Bindable
import androidx.lifecycle.*
import androidx.room.Room
import kotlinx.coroutines.launch


// 뷰모델은 DB에 직접 접근하지 않아야함. Repository 에서 데이터 통신.
class NoticeViewModel(application: Application) :AndroidViewModel(application) {

    private val repository = NoticeRepository(application)
    private val notices = repository.getAll()


    private val db = Room.databaseBuilder(
        application,
        NoticeDatabase::class.java, "notice_db"
    ).build()

    fun getAll(): LiveData<List<Notice>> {
        return this.notices
    }

    fun insert(notice: Notice) {
        repository.insert(notice)
    }



}////