package com.example.remindme

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.widget.CalendarView;
import android.widget.TextView

class PaginaInicioFragment  : Fragment() {
    lateinit var paginaInicio: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreate(savedInstanceState)
        val paginaInicioView: View = inflater.inflate(R.layout.fragment_pagina_inicio, container, false)
        paginaInicio = paginaInicioView.findViewById<TextView>(R.id.paginaInicio)
        return paginaInicioView
    }
}