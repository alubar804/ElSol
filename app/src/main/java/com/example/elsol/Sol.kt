package com.example.elsol


import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.widget.Toolbar

import androidx.recyclerview.widget.RecyclerView

class Travels(val imagen:Int,val titulo:String )
class TravelAdapter(var items: ArrayList<Travels>) : RecyclerView.Adapter<TravelAdapter.TarjViewHolder>() {
    lateinit var onClick : (View) -> Unit

    init {
        this.items = items
    }

    class TarjViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var laImagen: ImageView
        var elToolbar: Toolbar
        init {
            laImagen=itemView.findViewById(R.id.imageView)
            elToolbar=itemView.findViewById(R.id.toolbar)
            elToolbar.inflateMenu(R.menu.menu_main)


        }

        fun bindTarjeta(t: Travels, onClick: (View) -> Unit) = with(itemView) {
            laImagen.setImageResource(t.imagen)
            elToolbar.setTitle(t.titulo)

            setOnClickListener { onClick(itemView) }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): TarjViewHolder {
        val itemView = LayoutInflater.from(viewGroup.context).inflate(R.layout.sol, viewGroup, false)
        return TarjViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: TarjViewHolder, pos: Int) {
        val item = items.get(pos)
        viewHolder.bindTarjeta(item, onClick)
        viewHolder.elToolbar.setOnMenuItemClickListener(object :Toolbar.OnMenuItemClickListener {
            override fun onMenuItemClick(item: MenuItem): Boolean {
                when(item.itemId){
                    R.id.copiar ->{
                        items.add(items[viewHolder.adapterPosition])
                        notifyItemInserted(viewHolder.adapterPosition)
                    }

                    R.id.eliminar -> {
                        items.removeAt(viewHolder.adapterPosition)
                        notifyItemRemoved(viewHolder.adapterPosition)
                    }
                    else -> return true
                }
                return true
            }
        })
    }

    override fun getItemCount(): Int {
        return items.size
    }
}