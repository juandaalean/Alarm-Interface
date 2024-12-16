package com.example.dditask6

import androidx.recyclerview.widget.DiffUtil

class AlarmDiffUtil : DiffUtil.ItemCallback<Alarm>(){
    override fun areItemsTheSame(oldItem: Alarm, newItem: Alarm): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: Alarm, newItem: Alarm): Boolean {
        return oldItem == newItem
    }
}