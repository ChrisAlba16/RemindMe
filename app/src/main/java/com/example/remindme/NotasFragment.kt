package com.example.remindme

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.AdapterView.OnItemClickListener
import androidx.fragment.app.Fragment

class NotasFragment  : Fragment() {
    lateinit var editNotas: EditText
    lateinit var notas: ListView
    lateinit var botonGuardar: Button

    lateinit var list: ArrayList<String>
    lateinit var adapter: ArrayAdapter<String>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreate(savedInstanceState)
        val notasView: View = inflater.inflate(R.layout.fragment_notas, container, false)
        notas = notasView.findViewById<ListView>(R.id.notas)
        editNotas = notasView.findViewById<EditText>(R.id.editNotas)
        botonGuardar = notasView.findViewById<Button>(R.id.botonGuardar)

        list = ArrayList()
        list.add("La felicidad no es la meta, sino el camino")
        adapter = ArrayAdapter<String>(requireContext(),android.R.layout.simple_list_item_1, list)
        notas.adapter = adapter

        botonGuardar.setOnClickListener{
            list.add(editNotas.text.toString())
            adapter.notifyDataSetChanged()
        }

        notas.setClickable(true)
        notas.setOnItemClickListener(OnItemClickListener { arg0, arg1, position, arg3 ->
            fun showdialog(){
                val builder: AlertDialog.Builder = android.app.AlertDialog.Builder(requireContext())
                builder.setTitle("Opciones")

                val input = EditText(requireContext())
                input.setHint("Modificar texto")
                input.inputType = InputType.TYPE_CLASS_TEXT
                builder.setView(input)

                builder.setNegativeButton("Eliminar", DialogInterface.OnClickListener { dialog, which ->
                    list.remove(notas.getItemAtPosition(position).toString())
                    adapter.notifyDataSetChanged()
                })
                builder.setPositiveButton("Editar", DialogInterface.OnClickListener { dialog, which ->
                    list.remove(notas.getItemAtPosition(position).toString())
                    list.add(input.text.toString())
                    adapter.notifyDataSetChanged()
                })
                builder.setNeutralButton("Cancelar", DialogInterface.OnClickListener { dialog, which -> dialog.cancel()                })
                builder.show()
            }
            showdialog()
        })
        return notasView
    }
}
