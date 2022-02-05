package com.example.appaskuseranswer.db

import androidx.room.PrimaryKey
import io.realm.RealmObject

open class Notice: RealmObject() {

    @PrimaryKey
    var nNum: Int = 0

    var title: String = ""
    var content: String = ""
    var date: String = ""

}////