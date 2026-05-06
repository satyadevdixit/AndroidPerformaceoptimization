package com.example.androidperformanceoptimization.ui.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.androidperformanceoptimization.databinding.ListItemBinding
import com.example.androidperformanceoptimization.model.CategoriesDetailpojo

class CategoryAdapter(
    private val context: Context
) : ListAdapter<CategoriesDetailpojo, CategoryAdapter.ViewHolder>(CategoryDiffUtil) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding =
            ListItemBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding,context)
    }

    override fun getItemCount(): Int = currentList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int, payloads: MutableList<Any>) {
        if (payloads.isNotEmpty()) {
            val payload = payloads.firstOrNull() as? Bundle
            if (payload != null) {
                payload.getString(CategoryDiffUtil.ARG_COUNTRY_NAME)?.let {
                    holder.binding.textViewName.text = it
                }
                if (payload.containsKey(CategoryDiffUtil.ARG_COUNT)) {
                    holder.binding.textViewCount.text =
                        payload.getInt(CategoryDiffUtil.ARG_COUNT).toString()
                }
                return
            }
        }
        super.onBindViewHolder(holder, position, payloads)
    }



inner class ViewHolder(var binding: ListItemBinding,val context: Context):androidx.recyclerview.widget.RecyclerView.ViewHolder(binding.root) {
    fun bind(categoriesItempojo: CategoriesDetailpojo) {
        binding.category = categoriesItempojo
        binding.layoutCategoryListItem.setOnClickListener {
            val intent: Intent = Intent(context, DetailActivity::class.java)
            val bundle = Bundle()
            bundle.putSerializable("currency",categoriesItempojo.currency)
            bundle.putSerializable("countryname",categoriesItempojo.countryName)
            intent.putExtra("data", bundle)
            context.startActivity(intent)
        }

        binding.buttonAddCountyList.setOnClickListener {
            val updatedCount = categoriesItempojo.count + 1
            if (validateCountvalue(updatedCount, 50, 90)) {
                val updatedItem = categoriesItempojo.copy(count = updatedCount)
                submitUpdatedItem(updatedItem, bindingAdapterPosition)
            }
        }
        binding.buttonMinusCountryList.setOnClickListener {
            val updatedCount = categoriesItempojo.count - 1
            if (validateCountvalue(updatedCount, 50, 90)) {
                val updatedItem = categoriesItempojo.copy(count = updatedCount)
                submitUpdatedItem(updatedItem, bindingAdapterPosition)
            }
        }
    }
}

    private fun submitUpdatedItem(updatedItem: CategoriesDetailpojo, position: Int) {
        if (position == RecyclerView.NO_POSITION) return
        val newList = currentList.toMutableList()
        if (position in newList.indices) {
            newList[position] = updatedItem
            submitList(newList)
        }
    }

     fun validateCountvalue(
        currentValue: Int,
        lowLimitValue: Int,
        maxLimitValue: Int
    ): Boolean {
        return currentValue > lowLimitValue && currentValue < maxLimitValue
    }


}