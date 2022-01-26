package com.example.appaskuseranswer.test

import android.content.Context
import android.util.Log
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.appaskuseranswer.db.Notice
import com.example.appaskuseranswer.db.NoticeDao
import com.example.appaskuseranswer.db.NoticeDatabase
import junit.framework.TestCase
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class NoticeDatabaseTest : TestCase(){

    private lateinit var db: NoticeDatabase
    private lateinit var dao: NoticeDao

    @Before
    public override fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()

        db = Room.inMemoryDatabaseBuilder(context, NoticeDatabase::class.java).build()
        dao = db.noticeDao()
    }


    @After
    fun closeDb() {
        db.close()
    }

    @Test
    fun testNoticeDao() = runBlocking {



    }
}