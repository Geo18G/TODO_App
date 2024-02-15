package com.example.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    lateinit var etNombre: EditText
    lateinit var btnGuardar: Button
    lateinit var descripcion: TextView
    lateinit var listaElementos: ListView
    private lateinit var binding: ActivityMainBinding
    private val tareasViewModel : TareasViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etNombre = findViewById(R.id.etNombre)
        btnGuardar = findViewById(R.id.btnGuardarNom)
        descripcion = findViewById(R.id.descripcion)
        listaElementos = findViewById(R.id.lvElementos)


        var elementos = mutableListOf<String>()
        elementos.add("primer elemento")
        elementos.add("segundo elemento")
        var adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,elementos)

        listaElementos.adapter = adapter
        btnGuardar.setOnClickListener {
            val contenido = etNombre.text.toString()
            elementos.add(contenido)
            adapter.notifyDataSetChanged()
            Toast.makeText(this,("Éxito, total elementos: ${elementos.size}"),Toast.LENGTH_SHORT).show()
            Log.d(toString(), etNombre.text.toString())
            Log.d(toString(), descripcion.text.toString())
        }
    }
}