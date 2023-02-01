package com.example.androidperformanceoptimization.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.androidperformanceoptimization.databinding.ListItemBinding
import com.example.androidperformanceoptimization.model.CategoriesDetailpojo
import com.example.androidperformanceoptimization.model.Categoryitempojo

//AsyncDifferConfig.Builder<Item>(DiffCallback()).build()
class CategoryAdapter(val categorylist:MutableList<Categoryitempojo>): RecyclerView.Adapter<ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = categorylist.get(position)
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding =
            ListItemBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {

        Log.e("categoryAdapter",categorylist.size.toString())
      return  categorylist.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int, payloads: MutableList<Any>) {
        super.onBindViewHolder(holder, position, payloads)
        if (payloads.isNotEmpty()) {
            val payload: Bundle =
                payloads.get(position) as Bundle//?.let {it: android.os.Bundle ->it.getString(CategoryDifutil.ARG_DONE)}
            if (payload.getString(CategoryDifutil.ARG_DONE) != null) {
                holder.binding.item.setText(payload.getString(CategoryDifutil.ARG_DONE))
            }
        }
    }
}


class ViewHolder(var binding: ListItemBinding):androidx.recyclerview.widget.RecyclerView.ViewHolder(binding.root)
{
fun bind(categoriesItempojo: Categoryitempojo)
{
    binding.category = categoriesItempojo.item
}
}