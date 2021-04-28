package com.example.remindme

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.widget.CalendarView;

class CalendarioFragment  : Fragment() {
    lateinit var calendario: CalendarView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreate(savedInstanceState)
        val calendarioView: View = inflater.inflate(R.layout.fragment_calendario, container, false)
        calendario = calendarioView.findViewById<CalendarView>(R.id.calendario)
        return calendarioView
    }
}