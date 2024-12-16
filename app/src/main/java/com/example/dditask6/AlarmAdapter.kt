package com.example.dditask6

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter

class AlarmAdapter(
    private val onSwitchToggled: (Alarm) -> Unit
) : ListAdapter<Alarm, AlarmViewHolder>(AlarmDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlarmViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_alarm, parent, false)
        return AlarmViewHolder(view)
    }

    override fun onBindViewHolder(holder: AlarmViewHolder, position: Int) {
        val alarm = getItem(position)
        holder.bind(alarm, onSwitchToggled)
    }
}