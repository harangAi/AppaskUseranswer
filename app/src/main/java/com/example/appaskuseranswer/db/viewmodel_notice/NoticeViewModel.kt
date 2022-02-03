package com.example.appaskuseranswer.db.viewmodel_notice



import androidx.lifecycle.*
import com.example.appaskuseranswer.db.model.Notice
import com.example.appaskuseranswer.db.repository.NoticeRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


// 뷰모델은 DB에 직접 접근하지 않아야함. Repository 에서 데이터 통신.
class NoticeViewModel(private val noticeRepository: NoticeRepository): ViewModel() {

    val isNoticeInsertComplete = MutableLiveData<Int>()

    val isGetAllNoticeComplete = MutableLiveData<List<Notice>>()

    val isGetOneNoticeComplete = MutableLiveData<Notice>()

    fun insertNotice(notice: Notice) {
        CoroutineScope(Dispatchers.IO).launch {
            noticeRepository.insertNotice(notice).let {
                id ->
                isNoticeInsertComplete.postValue(id)
            }
        }
    }

    fun getAllNotice() {
        CoroutineScope(Dispatchers.IO).launch {
            noticeRepository.getAllNotice().let {
                isGetAllNoticeComplete.postValue(it)
            }
        }
    }

    fun  getOneNotice(id: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            noticeRepository.getOneNotice(id).let {
                isGetOneNoticeComplete.postValue(it)
            }
        }
    }


}////