package com.example.elsol

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView

class CompararPlanetas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comparar_planetas)
        var planetaLista = arrayOf("Mercurio", "Venus", "Tierra","Marte","Júpiter","Saturno","Urano","Neptuno","Plutón")

        var list_planetas1 = findViewById<AutoCompleteTextView>(R.id.Planeta1)
        val list_planetas2 = findViewById<AutoCompleteTextView>(R.id.Planeta2)

        var adaptador = ArrayAdapter<String> (this, android.R.layout.simple_dropdown_item_1line, planetaLista)

        list_planetas1.setAdapter( adaptador)
        list_planetas1.threshold = 1
        list_planetas2.setAdapter( adaptador)
        list_planetas2.threshold = 1
    }
}