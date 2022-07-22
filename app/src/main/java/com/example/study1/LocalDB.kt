package com.example.study1

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns

class LocalDB(
    context: Context?,
    name: String?,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int
) : SQLiteOpenHelper(context, name, factory, version) {
    override fun onCreate(db: SQLiteDatabase?) {

        if (db != null) {
            createDatabase(db)
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

        val sql : String = "DROP TABLE if exists ${LocalDatas.userData.TABLE_NAME}"

        if (db != null) {
            db.execSQL(sql)
            onCreate(db)
        }
    }

    fun createDatabase(db: SQLiteDatabase) {

        var sql: String = "CREATE TABLE if not exists ${LocalDatas.userData.TABLE_NAME} (" +
                "${BaseColumns._ID} integer primary key autoincrement," +
                "${LocalDatas.userData.COLUMN_NAME_ID} varchar(15)," +
                "${LocalDatas.userData.COLUMN_NAME_PASSWORD} varchar(20)"+
                ");"

        db.execSQL(sql)
    }
    fun registerUser(id: String, password:String){
        val db =this.writableDatabase
        val values = ContentValues().apply {
            put(LocalDatas.userData.COLUMN_NAME_ID, id)
            put(LocalDatas.userData.COLUMN_NAME_PASSWORD, password)
        }
        val newRowId = db?.insert(LocalDatas.userData.TABLE_NAME, null, values)

    }
    fun checkIdExist(id: String): Boolean {
        val db = this.readableDatabase


        val projection = arrayOf(BaseColumns._ID)



        //  WHERE "id" = id AND "password"=password 구문 적용하는 부분
        val selection = "${LocalDatas.userData.COLUMN_NAME_ID} = ?"
        val selectionArgs = arrayOf(id)

        //정렬조건 지정

        val cursor = db.query(
            LocalDatas.userData.TABLE_NAME,
            projection,
            selection,
            selectionArgs,
            null,
            null,
            null
        )
        if(cursor.count>0){ //반환된 cursor 값이 존재
            return true;
        }else{ //반환된 cursor 값이 없음
            return false;
        }
    }
    fun logIn(id: String, password:String): Boolean {
        val db = this.readableDatabase


        val projection = arrayOf(BaseColumns._ID)

        //  WHERE "id" = id AND "password"=password 구문 적용하는 부분
        val selection = "${LocalDatas.userData.COLUMN_NAME_ID} = ? AND ${LocalDatas.userData.COLUMN_NAME_PASSWORD} = ?"
        val selectionArgs = arrayOf(id,password)

//         정렬조건 지정
//        val sortOrder = "${FeedEntry.COLUMN_NAME_SUBTITLE} DESC"

        val cursor = db.query(
            LocalDatas.userData.TABLE_NAME,
            projection,
            selection,
            selectionArgs,
            null,
            null,
            null
        )
        if(cursor.count>0){
            return true;
        }else{
            return false;
        }

    }
}