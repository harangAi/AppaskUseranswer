package com.example.appaskuseranswer

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.appaskuseranswer.db.Notice
import com.example.appaskuseranswer.db.NoticeDao
import com.example.appaskuseranswer.db.NoticeDatabase
import kotlinx.coroutines.runBlocking
import org.junit.After
import com.google.common.truth.Truth.assertThat
import com.google.common.truth.Truth.assertWithMessage;
import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Before
import java.io.IOException
import java.lang.Exception
import java.util.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    private lateinit var noticeDao: NoticeDao
    private lateinit var db : NoticeDatabase

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, NoticeDatabase::class.java).build()
        noticeDao = db.noticeDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun writeNotice() = runBlocking {
        val notice = Notice("공지사항 테스트입니다.", "공지사항 내용 테스트", "2021_01_22")
        noticeDao.insert(notice)
        val notices = noticeDao.getAll()
        assertThat(notices.contains(notice)).isTrue()


    }




}


/*
package com.example.appaskuseranswer

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.appaskuseranswer", appContext.packageName)
    }
}
* */