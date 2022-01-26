package com.example.appaskuseranswer

import android.content.Context
import android.nfc.Tag
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.appaskuseranswer.db.Notice
import com.example.appaskuseranswer.db.NoticeDao
import com.example.appaskuseranswer.db.NoticeDatabase
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert

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
    private lateinit var database : NoticeDatabase

    @Before
    fun setup() {
        /*val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, NoticeDatabase::class.java).build()
        noticeDao = db.noticeDao()*/

        Log.i("TAG", "[BeforeTest] ")
        database = Room.inMemoryDatabaseBuilder(InstrumentationRegistry
            .getInstrumentation().context, NoticeDatabase::class.java).build()


    }

    @After
    fun closeDb() {
        database.close()
    }


    @Test
    fun insertTest() {


    }






}////


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