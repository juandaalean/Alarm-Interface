package com.example.dditask6

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.switchmaterial.SwitchMaterial

class AlarmViewHolder(val view: View) : RecyclerView.ViewHolder(view){

    val title: TextView = view.findViewById(R.id.alarm_card_tittle)
    val description: TextView = view.findViewById(R.id.alarm_card_description)
    val switch: SwitchMaterial = view.findViewById(R.id.switch_alarm)

    fun bind(alarm: Alarm, onSwitchToggled: (Alarm) -> Unit) {
        title.text = alarm.title
        description.text = alarm.description

        switch.isChecked = alarm.isActive

        switch.setOnCheckedChangeListener { _, isChecked ->
            alarm.isActive = isChecked
            onSwitchToggled(alarm)
        }
    }
}