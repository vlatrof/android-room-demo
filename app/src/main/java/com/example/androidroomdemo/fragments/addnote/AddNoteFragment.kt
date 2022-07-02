package com.example.androidroomdemo.fragments.addnote

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.androidroomdemo.R
import com.example.androidroomdemo.constants.APP
import com.example.androidroomdemo.databinding.FragmentAddNoteBinding
import com.example.androidroomdemo.model.NoteModel

class AddNoteFragment : Fragment() {

    lateinit var binding: FragmentAddNoteBinding

    override fun onCreateView (
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddNoteBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProvider(this).get(AddNoteViewModel::class.java)

        binding.btnInsertNote.setOnClickListener {

            val note = NoteModel(
                title = binding.etSetTitle.text.toString(),
                description = binding.etSetDescription.text.toString())

            viewModel.insert(note) {}

            APP.navController.navigate(R.id.action_addNoteFragment_to_listOfNotesFragment)

        }

        binding.btnBack.setOnClickListener {

            APP.navController.navigate(R.id.action_addNoteFragment_to_listOfNotesFragment)

        }

    }

}