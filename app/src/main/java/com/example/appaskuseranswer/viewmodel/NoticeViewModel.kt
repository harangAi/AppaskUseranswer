package com.example.appaskuseranswer.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.example.appaskuseranswer.data.NoticeDatabase
import com.example.appaskuseranswer.model.Notice
import com.example.appaskuseranswer.repository.NoticeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

// 뷰모델은 DB에 직접 접근하지 않아야함. Repository 에서 데이터 통신.
class NoticeViewModel (application: Application): AndroidViewModel(application) {

    val getAll: LiveData<List<Notice>>
    private val repository: NoticeRepository

    init {
        val noticeDao = NoticeDatabase.getDatabase(application)!!.noticeDao()
        repository = NoticeRepository(noticeDao)
        getAll = repository.getAll.asLiveData()
    }

    fun addNotice(notice: Notice) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addNotice(notice)
        }
    }

    fun getTitle() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getTitle()
        }
    }

    fun getContents() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getContents()
        }
    }

    fun getDate() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getDate()
        }
    }

    //ViewModel에 파라미터를 넘기기 위해서, 파라미터를 포함한 Factory
    //객체를 생성하기 위한 클래스
    class Factory(val application: Application): ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return NoticeViewModel(application) as T
        }
    }


}////