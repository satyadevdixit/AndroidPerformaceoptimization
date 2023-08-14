package com.example.androidperformanceoptimization.ui.home

import android.os.Bundle
import androidx.recyclerview.widget.DiffUtil
import com.example.androidperformanceoptimization.model.CategoriesDetailpojo
import com.example.androidperformanceoptimization.model.PopulationCitiesListPojo


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
        return oldlist[oldItemPosition].id == newlist[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return when{
            oldlist[oldItemPosition].id==newlist[newItemPosition].id ->true
            oldlist[oldItemPosition].name == newlist[newItemPosition].name ->true
            else -> false
        }
    }

    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
        if (oldlist[oldItemPosition].name == newlist[newItemPosition].name) {
           return super.getChangePayload(oldItemPosition, newItemPosition)
        } else {
            val diff = Bundle()
            diff.putString(ARG_DONE, newlist[newItemPosition].name)
        }
        return super.getChangePayload(oldItemPosition, newItemPosition)
    }

}