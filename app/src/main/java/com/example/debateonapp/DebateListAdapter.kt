package com.example.debateonapp

import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DebateListAdapter (
    val homeDebates: List<DebaterListQuery.HomeDebate>
) : RecyclerView.Adapter<DebateListAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val debateTitle: TextView = view.findViewById(R.id.debateTitle)
        val debateCreatedBy: TextView = view.findViewById(R.id.debateCreatedBy)

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.debatelist, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val Debate = homeDebates.get(position)

        holder.debateTitle.text = Debate.title
        holder.debateCreatedBy.text = Debate.creatorName
    }

    override fun getItemCount(): Int {
        return homeDebates.size
    }

}


