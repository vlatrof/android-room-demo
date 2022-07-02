package com.example.androidroomdemo.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.androidroomdemo.database.dao.NoteDao
import com.example.androidroomdemo.model.NoteModel

@Database(entities = [NoteModel::class], version = 1)
abstract class NoteDatabase : RoomDatabase() {

    abstract fun getNoteDao(): NoteDao

    companion object {

        private var noteDatabase: NoteDatabase ?= null

        @Synchronized
        fun getInstance(context: Context): NoteDatabase {

            return if (noteDatabase == null) {
                noteDatabase = Room.databaseBuilder(context, NoteDatabase::class.java, "db").build()
                noteDatabase as NoteDatabase
            } else {
                return noteDatabase as NoteDatabase
            }

        }

    }

}