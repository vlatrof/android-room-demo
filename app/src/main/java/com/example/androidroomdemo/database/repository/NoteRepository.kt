package com.example.androidroomdemo.database.repository

import androidx.lifecycle.LiveData
import com.example.androidroomdemo.model.NoteModel

interface NoteRepository {

    val allNotes: LiveData<List<NoteModel>>

    suspend fun insertNote(note: NoteModel, onSuccess: () -> Unit)

    suspend fun deleteNote(note: NoteModel, onSuccess: () -> Unit)

}
