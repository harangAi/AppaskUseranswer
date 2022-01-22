package com.example.appaskuseranswer.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao //Data Access Object 데이터에 접근할 수 있는 메서드를 정의해놓은 인터페이스
interface NoticeDao{

    @Query("SELECT * FROM notice")
    fun getAll() : LiveData<List<Notice>>

    /* @Query("SELECT * FROM notice WHERE n_num = :nNum")
     fun loadAllByIds(userIds: IntArray): List<Notice>*/


    //(onConflict = OnConflictStrategy.REPLACE)
    //같은 id값을 가지고 있는 객체가 들어올 경우 새로 들어온 객체로 데이터를 대체하겠다는 의미
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(notice: Notice)

    //내부 저장소에 접근한 결과를 비동기적으로 처리해야 하기 때문에
    // 각 함수 앞에 suspend를 붙여 비동기 함수로 만들어 준다.

}
