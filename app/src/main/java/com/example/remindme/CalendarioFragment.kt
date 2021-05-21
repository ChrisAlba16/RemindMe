package com.example.remindme

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.content.DialogInterface
import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.CalendarView.OnDateChangeListener
import androidx.fragment.app.Fragment
import android.widget.AdapterView.OnItemClickListener
import java.util.*
import kotlin.collections.ArrayList


class CalendarioFragment  : Fragment() {
    lateinit var calendario: CalendarView
    lateinit var editEventos: EditText
    lateinit var eventos: ListView
    lateinit var botonGuardar: Button

    lateinit var list: ArrayList<String>
    lateinit var adapter: ArrayAdapter<String>


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreate(savedInstanceState)
        val calendarioView: View = inflater.inflate(R.layout.fragment_calendario, container, false)
        calendario = calendarioView.findViewById<CalendarView>(R.id.calendario)
        editEventos = calendarioView.findViewById<EditText>(R.id.editEventos)
        eventos = calendarioView.findViewById<ListView>(R.id.eventos)
        botonGuardar = calendarioView.findViewById<Button>(R.id.botonGuardar)

        list = ArrayList()
        list.add("Tener un buen dia - Hoy")
        adapter = ArrayAdapter<String>(requireContext(),android.R.layout.simple_list_item_1, list)
        eventos.adapter = adapter
        var fecha: String = " - Hoy"
        calendario.setOnDateChangeListener(OnDateChangeListener { view, year, month, dayOfMonth ->
            val curDate = dayOfMonth.toString()
            val Year = year.toString()
            val Month = month.toString()
            fecha = " - " + "$curDate/$Month/$Year"
        })

        botonGuardar.setOnClickListener{
            list.add(editEventos.text.toString() + fecha)
            adapter.notifyDataSetChanged()
        }

        eventos.setClickable(true)
        eventos.setOnItemClickListener(OnItemClickListener { arg0, arg1, position, arg3 ->
            fun showdialog(){
                val builder: AlertDialog.Builder = android.app.AlertDialog.Builder(requireContext())
                builder.setTitle("Opciones")

                builder.setNegativeButton("Eliminar", DialogInterface.OnClickListener { dialog, which ->
                    list.remove(eventos.getItemAtPosition(position).toString())
                    adapter.notifyDataSetChanged()
                })
                builder.setNeutralButton("Cancelar", DialogInterface.OnClickListener { dialog, which -> dialog.cancel()                })
                builder.show()
            }
            showdialog()
        })
        return calendarioView
    }
}