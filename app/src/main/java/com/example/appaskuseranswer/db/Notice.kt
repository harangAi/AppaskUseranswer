package com.example.appaskuseranswer.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

private const val TABLE_NAME = "notice"

//공지사항 테이블 생성
@Entity(tableName = TABLE_NAME)
data class Notice(
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "content") val content: String,
    @ColumnInfo(name = "date") var date: String
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "n_num")val nNum : Int = 0 // PK를 자동으로 증가하는 인덱스 설정
}
