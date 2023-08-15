package com.example.androidperformanceoptimization.ui.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.androidperformanceoptimization.databinding.ListItemBinding
import com.example.androidperformanceoptimization.model.CategoriesDetailpojo

//AsyncDifferConfig.Builder<Item>(DiffCallback()).build()
class CategoryAdapter(val categorylist:MutableList<CategoriesDetailpojo>,val context: Context): RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = categorylist.get(position)
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding =
            ListItemBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding,context)
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
                holder.binding.textViewName.setText(payload.getString(CategoryDifutil.ARG_DONE))
            }
        }
    }



inner class ViewHolder(var binding: ListItemBinding,val context: Context):androidx.recyclerview.widget.RecyclerView.ViewHolder(binding.root) {
    fun bind(categoriesItempojo: CategoriesDetailpojo) {
        binding.category = categoriesItempojo
        binding.layoutCategoryListItem.setOnClickListener {
            val intent: Intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("index", bindingAdapterPosition)
            context.startActivity(intent)
        }

        binding.buttonAddCountyList.setOnClickListener {
            if (validateCountvalue(++categoriesItempojo.count, 50, 90))
                binding.textViewCount.setText((++categoriesItempojo.count).toString())
        }
        binding.buttonMinusCountryList.setOnClickListener {
            if (validateCountvalue(++categoriesItempojo.count, 50, 90))
                binding.textViewCount.setText((--categoriesItempojo.count).toString())
        }
    }
}

     fun validateCountvalue(
        currentValue: Int,
        lowLimitValue: Int,
        maxLimitValue: Int
    ): Boolean {
        if (currentValue > lowLimitValue && currentValue < maxLimitValue)
            return true
        else
            return false
    }


}