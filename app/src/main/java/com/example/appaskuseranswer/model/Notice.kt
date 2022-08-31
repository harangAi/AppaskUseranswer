package com.example.appaskuseranswer.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notice_table")
data class Notice(@PrimaryKey(autoGenerate = true) val id: Int,
                    @ColumnInfo(name = "title") val title: String,
                  @ColumnInfo(name = "contents") val contents: String,
                  @ColumnInfo(name = "date") val date: String)
