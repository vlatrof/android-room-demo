package com.example.androidroomdemo.fragments.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.androidroomdemo.R
import com.example.androidroomdemo.constants.APP
import com.example.androidroomdemo.databinding.FragmentDetailsBinding
import com.example.androidroomdemo.model.NoteModel

class DetailsFragment : Fragment() {

    lateinit var binding: FragmentDetailsBinding
    lateinit var currentNote: NoteModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsBinding.inflate(layoutInflater, container, false)
        currentNote = arguments?.getSerializable("note") as NoteModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvNoteDetailsTitle.text = currentNote.title
        binding.tvNoteDetailsDescription.text = currentNote.description

        val viewModel = ViewModelProvider(this).get(DetailsViewModel::class.java)

        binding.btnDeleteNote.setOnClickListener {

            viewModel.delete(currentNote) {}

            APP.navController.navigate(R.id.action_detailsFragment_to_listOfNotesFragment)

        }

        binding.btnBack.setOnClickListener {

            APP.navController.navigate(R.id.action_detailsFragment_to_listOfNotesFragment)

        }

    }

}