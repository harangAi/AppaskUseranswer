package com.example.appaskuseranswer.common

import android.app.Application
import androidx.room.Room
import com.example.appaskuseranswer.db.NoticeDatabase

class GlobalApplication : Application() {

    companion object {
        lateinit var appInstance: GlobalApplication
            private set

        lateinit var appDataBaseInstance: NoticeDatabase
            private set

    }

    override fun onCreate() {
        super.onCreate()
        appInstance = this

        appDataBaseInstance = Room.databaseBuilder(
            appInstance.applicationContext,
            NoticeDatabase::class.java, "example.db"
        )
            .fallbackToDestructiveMigration() //DB version 달라졌을 경우 데이터베이스 초기화
            .allowMainThreadQueries() //메인 스레드에서 접근 허용
            .build()
    }

}////