package com.example.remindme

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.AdapterView.OnItemClickListener
import androidx.fragment.app.Fragment

class PendientesFragment  : Fragment() {
    lateinit var editPendientes: EditText
    lateinit var pendientes: ListView
    lateinit var botonGuardar: Button

    lateinit var list: ArrayList<String>
    lateinit var adapter: ArrayAdapter<String>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreate(savedInstanceState)
        val pendientesView: View = inflater.inflate(R.layout.fragment_pendientes, container, false)
        editPendientes = pendientesView.findViewById<EditText>(R.id.editPendientes)
        pendientes = pendientesView.findViewById<ListView>(R.id.pendientes)
        botonGuardar = pendientesView.findViewById<Button>(R.id.botonGuardar)

        list = ArrayList()
        list.add("Calificar RemindMe en la Play Store")
        adapter = ArrayAdapter<String>(requireContext(),android.R.layout.simple_list_item_1, list)
        pendientes.adapter = adapter
        botonGuardar.setOnClickListener{
            list.add(editPendientes.text.toString())
            adapter.notifyDataSetChanged()
        }
        pendientes.setClickable(true)
        pendientes.setOnItemClickListener(OnItemClickListener { arg0, arg1, position, arg3 ->
            fun showdialog(){
                val builder: AlertDialog.Builder = android.app.AlertDialog.Builder(requireContext())
                builder.setTitle("Opciones")

                builder.setNegativeButton("Realizada", DialogInterface.OnClickListener { dialog, which ->
                    list.remove(pendientes.getItemAtPosition(position).toString())
                    adapter.notifyDataSetChanged()
                })
                builder.setNeutralButton("Cancelar", DialogInterface.OnClickListener { dialog, which -> dialog.cancel()                })
                builder.show()
            }
            showdialog()
        })
        return pendientesView
    }
}