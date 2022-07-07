package com.example.androidroomdemo.database.repository

import androidx.lifecycle.LiveData
import com.example.androidroomdemo.database.dao.NoteDao
import com.example.androidroomdemo.model.NoteModel

class NoteRepositoryImpl(private val noteDao: NoteDao) : NoteRepository{

    override val allNotes: LiveData<List<NoteModel>>
        get() = noteDao.getAllNotes()

    override suspend fun insertNote(note: NoteModel, onSuccess: () -> Unit) {
        noteDao.insert(note)
        onSuccess()
    }

    override suspend fun deleteNote(note: NoteModel, onSuccess: () -> Unit) {
        noteDao.delete(note)
        onSuccess()
    }

}