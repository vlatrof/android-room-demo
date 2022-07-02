package com.example.androidroomdemo.fragments.addnote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidroomdemo.constants.REPOSITORY
import com.example.androidroomdemo.model.NoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddNoteViewModel : ViewModel() {

    fun insert(noteModel: NoteModel, onSuccess: () -> Unit) {

        viewModelScope.launch (Dispatchers.IO) {
            REPOSITORY.insertNote( noteModel, { onSuccess() } )
        }

    }

}