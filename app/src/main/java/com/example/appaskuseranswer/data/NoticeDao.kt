package com.example.appaskuseranswer.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.appaskuseranswer.model.Notice
import kotlinx.coroutines.flow.Flow

@Dao
interface NoticeDao {

    @Query("SELECT * FROM notice_table")
    fun getAll() : Flow<List<Notice>>

    //id가 가장 큰 (최신) 제목만 조회
    @Query("SELECT title FROM notice_table WHERE MAX(id)")
    fun getTitle() : String

    //id가 가장 큰 (최신) 내용만 조회
    @Query("SELECT contents FROM notice_table WHERE MAX(id)")
    fun getContents() : String

    //id가 가장 큰 (최신) 날짜만 조회
    @Query("SELECT date FROM notice_table WHERE MAX(id)")
    fun getDate() : String



    @Insert
    suspend fun addNoticeDb(notices: List<Notice>)

    //OnConflictStrategy.IGNORE = 동일한 아이디가 있을 시 무시
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addNotice(notice: Notice)

}////