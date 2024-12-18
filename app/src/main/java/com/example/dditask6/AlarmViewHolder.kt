package com.example.dditask6

import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.switchmaterial.SwitchMaterial

class AlarmViewHolder(val view: View) : RecyclerView.ViewHolder(view){

    val title: TextView = view.findViewById(R.id.alarm_card_tittle)
    val description: TextView = view.findViewById(R.id.alarm_card_description)
    val switch: SwitchMaterial = view.findViewById(R.id.switch_alarm)
    val cardView: CardView = view as CardView

    fun bind(alarm: Alarm, onSwitchToggled: (Alarm) -> Unit) {
        title.text = alarm.title
        description.text = alarm.description
        switch.isChecked = alarm.isActive

        updateCardOpacity(alarm.isActive)

        switch.setOnCheckedChangeListener { _, isChecked ->
            alarm.isActive = isChecked
            onSwitchToggled(alarm)
            updateCardOpacity(isChecked)
        }
    }

    private fun updateCardOpacity(isActive: Boolean){
        val activeAlpha = 1.0f
        val inactiveAlpha = 0.5f
        cardView.alpha = if (isActive) activeAlpha else inactiveAlpha
    }
}