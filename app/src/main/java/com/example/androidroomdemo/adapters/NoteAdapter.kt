package com.example.androidroomdemo.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidroomdemo.R
import com.example.androidroomdemo.fragments.listofnotes.ListOfNotesFragment
import com.example.androidroomdemo.model.NoteModel
import kotlinx.android.synthetic.main.item_layout.view.*

class NoteAdapter: RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    var notesList = emptyList<NoteModel>()

    class NoteViewHolder(view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.itemView.item_title.text = notesList[position].title
    }

    override fun getItemCount(): Int {
        return notesList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<NoteModel>) {
        notesList = list
        notifyDataSetChanged()
    }

    override fun onViewAttachedToWindow(holder: NoteViewHolder) {
        super.onViewAttachedToWindow(holder)
        holder.itemView.setOnClickListener{
            ListOfNotesFragment.onClickToNote(notesList[holder.adapterPosition])
        }
    }

    override fun onViewDetachedFromWindow(holder: NoteViewHolder) {
        holder.itemView.setOnClickListener(null)
    }

}