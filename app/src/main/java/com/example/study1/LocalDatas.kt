package com.example.study1

import android.provider.BaseColumns

object LocalDatas {
    object userData : BaseColumns {
        const val TABLE_NAME = "users"
        const val COLUMN_NAME_ID = "id"
        const val COLUMN_NAME_PASSWORD = "password"
    }
    object Groups :BaseColumns{ // 만약 그룹에 관련한 DB 형식을 지정하고 싶다면 동일한 방식으로 추가

    }
}