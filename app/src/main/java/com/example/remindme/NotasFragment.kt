package com.example.remindme
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.widget.CalendarView;
import android.widget.TextView

class NotasFragment  : Fragment() {
    lateinit var notas: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreate(savedInstanceState)
        val notasView: View = inflater.inflate(R.layout.fragment_notas, container, false)
        notas = notasView.findViewById<TextView>(R.id.notas)
        return notasView
    }
}
