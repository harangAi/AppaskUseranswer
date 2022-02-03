package com.example.appaskuseranswer.db

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.appaskuseranswer.db.dao.NoticeDao
import org.junit.After
import org.junit.Before
import org.junit.runner.RunWith
import java.io.IOException


@RunWith(AndroidJUnit4::class)
class NoticeDatabaseTest {

    private lateinit var  noticeDao: NoticeDao
    private lateinit var db: NoticeDatabase

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext

        db = Room.inMemoryDatabaseBuilder(context, NoticeDatabase::class.java)
            .allowMainThreadQueries()
            .build()
        noticeDao = db.noticeDao()

    }

    @After
    @Throws(IOException::class)
    fun  closeDb() {
        db.close()
    }

  /*  @Test
    @Throws(Exception::class)
    fun insertAndGetNotice() {
        val notice = Notice("공지사항 테스트", "공지사항 내용 테스트", "2022년 02월 01일 (화)")
        noticeDao.insert(notice)
        val noticeTest = noticeDao.getAll()

        Log.d(notice.toString(),"A")
        Log.d(noticeTest.toString(), "B")
    }*/


  /*  @Test
    @Throws(Exception::class)
    fun iWantToKnowTheDatabaseIsFind() = runBlocking {
        val not = Notice("테스트", "내용 테스트", "2022년 02월 01일 (화)")
        noticeDao.insert(not)
        val noticeTest = noticeDao.getAll()

        Log.d(not.toString(),"A")
        Log.d(noticeTest.toString(), "B")
    }*/

}