package com.example.androidroomdemo.fragments.listofnotes

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.androidroomdemo.constants.REPOSITORY
import com.example.androidroomdemo.database.NoteDatabase
import com.example.androidroomdemo.database.repository.NoteRepositoryImpl
import com.example.androidroomdemo.model.NoteModel

class ListOfNotesViewModel(application: Application): AndroidViewModel(application) {

    private val context = application

    fun initDatabase() {
        val dbInstance = NoteDatabase.getInstance(context)
        val noteDaoImpl = dbInstance.getNoteDao()
        REPOSITORY = NoteRepositoryImpl(noteDaoImpl)
    }

    fun getAllNotes(): LiveData<List<NoteModel>> {
        return REPOSITORY.allNotes
    }

}