package com.example.androidroomdemo.fragments.listofnotes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.androidroomdemo.R
import com.example.androidroomdemo.adapters.NoteAdapter
import com.example.androidroomdemo.constants.APP
import com.example.androidroomdemo.databinding.FragmentListOfNotesBinding
import com.example.androidroomdemo.model.NoteModel

class ListOfNotesFragment : Fragment() {

    lateinit var binding: FragmentListOfNotesBinding
    lateinit var recyclerView: RecyclerView
    lateinit var noteAdapter: NoteAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListOfNotesBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        val listOfNotesViewModel = ViewModelProvider(this).get(ListOfNotesViewModel::class.java)
        listOfNotesViewModel.initDatabase() // create new db instance or get existed
        recyclerView = binding.rvListOfNotes
        noteAdapter = NoteAdapter()
        recyclerView.adapter = noteAdapter

        listOfNotesViewModel.getAllNotes().observe(viewLifecycleOwner) { listOfNotes ->
            noteAdapter.setList(listOfNotes.asReversed())
        }

        binding.btnAddNote.setOnClickListener {
            APP.navController.navigate(R.id.action_listOfNotesFragment_to_addNoteFragment)
        }

    }

    companion object {

        fun onClickToNote(noteModel: NoteModel){

            val bundle = Bundle()
            bundle.putSerializable("note", noteModel)
            APP.navController.navigate(R.id.action_listOfNotesFragment_to_detailsFragment, bundle)

        }

    }

}