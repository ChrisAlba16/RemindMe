package com.example.remindme

import android.media.Image
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.widget.CalendarView
import android.widget.ImageView
import android.widget.TextView

class PaginaInicioFragment  : Fragment() {
    lateinit var titulo: TextView
    lateinit var a: ImageView
    lateinit var b: TextView
    lateinit var c: TextView
    lateinit var d: TextView
    lateinit var e: TextView
    lateinit var f: TextView
    lateinit var g: TextView



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreate(savedInstanceState)
        val paginaInicioView: View = inflater.inflate(R.layout.fragment_pagina_inicio, container, false)
        titulo = paginaInicioView.findViewById<TextView>(R.id.textTituloSeccion)
        a = paginaInicioView.findViewById<ImageView>(R.id.a)
        b = paginaInicioView.findViewById<TextView>(R.id.b)
        c = paginaInicioView.findViewById<TextView>(R.id.c)
        d = paginaInicioView.findViewById<TextView>(R.id.d)
        e = paginaInicioView.findViewById<TextView>(R.id.e)
        f = paginaInicioView.findViewById<TextView>(R.id.f)
        g = paginaInicioView.findViewById<TextView>(R.id.g)



        return paginaInicioView
    }
}