package com.example.androidperformanceoptimization.ui.home

import android.os.Bundle
import androidx.recyclerview.widget.DiffUtil
import com.example.androidperformanceoptimization.model.Categoryitempojo


class CategoryDifutil(val newlist:List<Categoryitempojo>, val oldlist:List<Categoryitempojo>): DiffUtil.Callback(){

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
        return oldlist[oldItemPosition].item.id == newlist[newItemPosition].item.id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return when{
            oldlist[oldItemPosition].item.id==newlist[newItemPosition].item.id ->true
            oldlist[oldItemPosition].item.name == newlist[newItemPosition].item.name ->true
            else -> false
        }
    }

    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
        if (oldlist[oldItemPosition].item.name == newlist[newItemPosition].item.name) {
           return super.getChangePayload(oldItemPosition, newItemPosition)
        } else {
            val diff = Bundle()
            diff.putString(ARG_DONE, newlist[newItemPosition].item.name)
        }
        return super.getChangePayload(oldItemPosition, newItemPosition)
    }

}