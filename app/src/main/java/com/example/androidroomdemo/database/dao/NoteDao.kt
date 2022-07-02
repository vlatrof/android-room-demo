package com.example.androidroomdemo.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.androidroomdemo.model.NoteModel

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(noteModel: NoteModel )

    @Delete
    suspend fun delete(noteModel: NoteModel)

    @Query("SELECT * FROM notes_table")
    fun getAllNotes(): LiveData<List<NoteModel>>

}