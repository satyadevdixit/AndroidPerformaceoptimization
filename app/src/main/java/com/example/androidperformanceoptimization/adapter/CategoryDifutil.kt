package com.example.androidperformanceoptimization.ui.home

import android.os.Bundle
import androidx.recyclerview.widget.DiffUtil
import com.example.androidperformanceoptimization.model.CategoriesDetailpojo


class CategoryDifutil(val newlist:List<CategoriesDetailpojo>, val oldlist:List<CategoriesDetailpojo>): DiffUtil.Callback(){

    companion object{
         val ARG_DONE = "arg.done"
    }

    override fun getOldListSize(): Int {
        return oldlist.size
    }

    override fun getNewListSize(): Int {
        return newlist.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldlist[oldItemPosition].currency == newlist[newItemPosition].currency
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return when{
            oldlist[oldItemPosition].currency==newlist[newItemPosition].currency ->true
            oldlist[oldItemPosition].countryName == newlist[newItemPosition].countryName ->true
            else -> false
        }
    }

    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
        if (oldlist[oldItemPosition].countryName == newlist[newItemPosition].countryName) {
           return super.getChangePayload(oldItemPosition, newItemPosition)
        } else {
            val diff = Bundle()
            diff.putString(ARG_DONE, newlist[newItemPosition].countryName)
        }
        return super.getChangePayload(oldItemPosition, newItemPosition)
    }

}