package com.example.elsol

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.AdapterView
import android.widget.TextView


class CompararPlanetas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comparar_planetas)
        val planetaLista = arrayOf("Mercurio", "Venus", "Tierra","Marte","Júpiter","Saturno","Urano","Neptuno","Plutón")
        val diametro= arrayListOf<String>("0,382","0,949","1","0,53","11,2","9,41","3,38","3,81","???")
        val distancia= arrayListOf<String>("0,387","0,723","1","1,542","5,203","9,539","19,81","30,07","39,44")
        val densidades= arrayListOf<String>("5400","5250","5520","3960","1350","700","1200","1500","5?")
        val list_planetas1 = findViewById<AutoCompleteTextView>(R.id.Planeta1)
        val list_planetas2 = findViewById<AutoCompleteTextView>(R.id.Planeta2)

        var adaptador = ArrayAdapter<String> (this, android.R.layout.simple_dropdown_item_1line, planetaLista)

        list_planetas1.setAdapter( adaptador)
        list_planetas1.threshold = 1
        list_planetas2.setAdapter( adaptador)
        list_planetas2.threshold = 1

        list_planetas1.onItemClickListener = AdapterView.OnItemClickListener{
                parent,view,position,id->
            val selectedItem = parent.getItemAtPosition(position).toString()

            for (i in planetaLista.indices){
                if (selectedItem.equals(planetaLista[i])){
                    val textoDensidad1=findViewById<TextView>(R.id.textDensidad1)
                    textoDensidad1.text=densidades[i]
                    val textoDistancia1=findViewById<TextView>(R.id.textDistancia1)
                    textoDistancia1.text=distancia[i]
                    val textoDiametro1=findViewById<TextView>(R.id.textDiametro1)
                    textoDiametro1.text=diametro[i]
                }
            }

        }
        list_planetas2.onItemClickListener = AdapterView.OnItemClickListener{
                parent,view,position,id->
            val selectedItem = parent.getItemAtPosition(position).toString()

            for (i in planetaLista.indices){
                if (selectedItem.equals(planetaLista[i])){
                    val textoDensidad2=findViewById<TextView>(R.id.textDensidad2)
                    textoDensidad2.text=densidades[i]
                    val textoDistancia2=findViewById<TextView>(R.id.textDistancia2)
                    textoDistancia2.text=distancia[i]
                    val textoDiametro2=findViewById<TextView>(R.id.textDiametro2)
                    textoDiametro2.text=diametro[i]
                }
            }
        }


    }
    fun setOnItemSelectedListener(l: AdapterView.OnItemSelectedListener?) {

    }
}