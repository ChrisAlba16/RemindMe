package com.example.remindme

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.widget.CalendarView;
import android.widget.TextView

class PendientesFragment  : Fragment() {
    lateinit var pendientes: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreate(savedInstanceState)
        val pendientesView: View = inflater.inflate(R.layout.fragment_pendientes, container, false)
        pendientes = pendientesView.findViewById<TextView>(R.id.pendientes)
        return pendientesView
    }
}