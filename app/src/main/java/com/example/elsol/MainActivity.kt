package com.example.elsol

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import androidx.appcompat.view.menu.MenuView
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.DefaultItemAnimator

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //TODO nueva actvidad en comparar palnetas



        val items = ArrayList<Travels>()
        items.add(Travels(R.drawable.manchasolar,"Mancha Solar"))
        items.add(Travels(R.drawable.espiculas,"Espiculas"))
        items.add(Travels(R.drawable.magnetosfera,"Magnetosfera"))
        items.add(Travels(R.drawable.erupcionsolar,"Erupcionsolar"))
        items.add(Travels(R.drawable.corona_solar,"Corona Solar"))
        items.add(Travels(R.drawable.filamentos,"Filamentos"))

        val recView = findViewById<RecyclerView>(R.id.recicler)
        val adaptador = TravelAdapter(items)
        recView.setHasFixedSize(true)
        recView.itemAnimator = DefaultItemAnimator()


        recView.adapter = adaptador
        recView.layoutManager = GridLayoutManager(this,2)
            adaptador.onClick = {


        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu1, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            (R.id.compara) -> {lanzarCompara()
                return true}
            else -> {return super.onOptionsItemSelected(item)} }
    }

    private fun lanzarCompara (){
        val i = Intent(this,CompararPlanetas::class.java)
        startActivity(i)
    }
}
