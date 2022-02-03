package com.example.appaskuseranswer.db.repository

import com.example.appaskuseranswer.common.GlobalApplication
import com.example.appaskuseranswer.db.model.Notice


// 앱에서 사용하는 데이터와 그 데이터 통신을 하는 역할
class NoticeRepository {

    private val appDBInstance = GlobalApplication.appDataBaseInstance.noticeDao()

    suspend fun insertNotice(notice: Notice) = appDBInstance.insert(notice)
    suspend fun getAllNotice() = appDBInstance.getAll()
    suspend fun getOneNotice(id: Int) = appDBInstance.getOneNotice(id)


}////