package com.example.dditask6

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view_alarm)
        val FAButton: ImageButton = findViewById(R.id.FAB)

        val alarmAdapter = AlarmAdapter { alarm ->
            val status = if (alarm.isActive) "activada" else "desactivada"
            Toast.makeText(this, "${alarm.title} ha sido $status", Toast.LENGTH_SHORT).show()
        }

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = alarmAdapter

        val alarmList = generateAlarms()
        alarmAdapter.submitList(alarmList)

        val pointsMenu: ImageView = findViewById(R.id.points_menu)
        pointsMenu.setOnClickListener { view ->
            showMenuPopup(view)
        }

        FAButton.setOnClickListener {
            Toast.makeText(this, "Añadir alarma", Toast.LENGTH_SHORT).show()
        }
    }

    private fun showMenuPopup(view: View) {
        val popupMenu = PopupMenu(this, view)
        val inflater: MenuInflater = popupMenu.menuInflater
        inflater.inflate(R.menu.points_menu, popupMenu.menu)
        popupMenu.show()
    }

    private fun generateAlarms(): List<Alarm> {
        return listOf(
            Alarm("6:30", "Sonar una vez", false),
            Alarm("7:30", "Sonar una vez | Alarma despertador", true),
            Alarm("7:43", "Sonar una vez | Alarma 2", false),
            Alarm("9:51", "Sonar una vez", false),
            Alarm("12:14", "Sonar una vez", false),
            Alarm("15:30", "Sonar una vez", false),
            Alarm("19:30", "Sonar una vez", false),
            Alarm("22:43", "Sonar una vez", false),
            Alarm("23:42", "Sonar una vez | Alarma noche", true),
        )
    }
}