package com.example.appaskuseranswer.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.appaskuseranswer.model.Notice
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities =[Notice::class], version = 1)
abstract class NoticeDatabase : RoomDatabase() {

    abstract fun noticeDao(): NoticeDao

    companion object {

        /*
        @Volatile = 접근 가능한 변수의 값을 cache를 통해 사용하지 않고
        thread가 직접 main memory에 접근하게하여 동기화
        * */
        @Volatile
        private var INSTANCE : NoticeDatabase? = null

        //싱글톤으로 생성 (자주 생성하면 성능 손해). 이미 존재할 경우 생성하지 않고 바로 반환
        fun getDatabase(context: Context) : NoticeDatabase? {
            if (INSTANCE == null) {
                synchronized(NoticeDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        NoticeDatabase::class.java,
                        "notice_database"
                    ).addCallback(object : RoomDatabase.Callback(){
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            fillInDb(context.applicationContext)
                        }
                    }).build()
                }
            }
            return INSTANCE
        }

        //데이터 미리 채우기
        fun fillInDb(context: Context) {
            CoroutineScope(Dispatchers.IO).launch {
                getDatabase(context)!!.noticeDao().addNoticeDb(
                    NOTICE_DATA
                )
            }
        }

    }

}////

private val NOTICE_DATA = arrayListOf(
    Notice(0,"공지사항 제목 테스트 000","공지사항 내용 000", "2022년 02월 09일 (수) 00:00"),
    Notice(1,"공지사항 제목 테스트 111","공지사항 내용 111", "2022년 02월 09일 (수) 11:11"),
    Notice(2,"공지사항 제목 테스트 222","공지사항 내용 333", "2022년 02월 09일 (수) 22:22")
)