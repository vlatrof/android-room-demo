package com.example.androidroomdemo.fragments.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidroomdemo.constants.REPOSITORY
import com.example.androidroomdemo.model.NoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailsViewModel : ViewModel() {

    fun delete(noteModel: NoteModel, onSuccess: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.deleteNote(noteModel) {
                onSuccess()
            }
        }
    }

}