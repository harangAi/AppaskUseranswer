package com.example.appaskuseranswer.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

//https://velog.io/@sasy0113/Android-Kotlin-Room

@Database(entities = [Notice::class],
            version = 1) /* 신규 변경사항이 생길 경우 version number를 올려주어야 하는 것은 물론,
                        이전 버전에서 신규 버전으로 올라가면서 달라진 점들에 대해 어떻게 변경사항을 집어넣을 것인지
                        Migration이라는 클래스를 사용해 작성하여 적용해주어야 한다.*/

/*
 fallbackToDestructiveMigration()을 사용하면 migartion을 추가하지 않아도 데이터베이스의 변경이 적용된다.
 단, 기존의 데이터베이스에 저장된 내용은 모두 날라간다.
* */

abstract class  NoticeDatabase : RoomDatabase() {
    abstract fun noticeDao() : NoticeDao

    companion object {  //어디서든 접근할 수 있게 compain object를 이용해서 싱글톤 패턴으로 만들어준다.

        /* @Volatile = 접근가능한 변수의 값을 cache를 통해 사용하지 않고
        thread가 직접 main memory에 접근 하게하여 동기화. */
        @Volatile
        private var instance : NoticeDatabase? = null

        // 싱글톤으로 생성 (자주 생성 시 성능 손해). 이미 존재할 경우 생성하지 않고 바로 반환
        @Synchronized
        fun getInstance(context: Context) : NoticeDatabase? {
            if (instance == null) {
                synchronized(NoticeDatabase::class) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        NoticeDatabase::class.java,"notice_database"
                    ).build()
                }
            }
            return instance
        }

    }

}////