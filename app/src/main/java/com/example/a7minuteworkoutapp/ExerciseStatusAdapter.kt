package com.example.a7minuteworkoutapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_exercise_status.view.*

class ExerciseStatusAdapter(val items:ArrayList<ExerciseModel>, val context:Context): RecyclerView.Adapter<ExerciseStatusAdapter.ViewHolder>(){
    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val tvItem = view.tvItem

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).
        inflate(R.layout.item_exercise_status,parent,
            false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model:ExerciseModel =items[position]
        holder.tvItem.text= model.getId().toString()
        if(model.getIsSelected()){
            holder.tvItem.background=ContextCompat.getDrawable(context, R.drawable.item_circular_thin_color_accent_border)

        }else if(model.getIsComplete()){
            holder.tvItem.background=ContextCompat.getDrawable(context, R.drawable.item_circular_color_accent_background)

        }else{
            holder.tvItem.background=ContextCompat.getDrawable(context,R.drawable.item_circular_color_magenta_bg)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}