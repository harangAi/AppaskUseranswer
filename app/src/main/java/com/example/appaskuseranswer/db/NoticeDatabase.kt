package com.example.appaskuseranswer.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.appaskuseranswer.db.dao.NoticeDao
import com.example.appaskuseranswer.db.model.Notice

//https://velog.io/@sasy0113/Android-Kotlin-Room

@Database(entities = [Notice::class],
            version = 1,
            exportSchema = false) /* 신규 변경사항이 생길 경우 version number를 올려주어야 하는 것은 물론,
                        이전 버전에서 신규 버전으로 올라가면서 달라진 점들에 대해 어떻게 변경사항을 집어넣을 것인지
                        Migration이라는 클래스를 사용해 작성하여 적용해주어야 한다.*/

/*
 fallbackToDestructiveMigration()을 사용하면 migartion을 추가하지 않아도 데이터베이스의 변경이 적용된다.
 단, 기존의 데이터베이스에 저장된 내용은 모두 날라간다.
* */

abstract class  NoticeDatabase : RoomDatabase() {

    abstract fun noticeDao(): NoticeDao

}////