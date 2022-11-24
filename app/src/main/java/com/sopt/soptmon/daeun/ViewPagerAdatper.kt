package com.sopt.soptmon.daeun

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sopt.soptmon.databinding.ItemExhibitposterBinding

class ViewPagerAdatper : RecyclerView.Adapter<ViewPagerAdatper.ViewHolder>() {

    lateinit var items: ArrayList<Int>

    fun build(i: ArrayList<Int>): ViewPagerAdatper {
        items = i
        return this
    }

    class ViewHolder(val binding: ItemExhibitposterBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Int) {
            binding.ivExhibitionPoster.setImageDrawable(binding.root.context.getDrawable(item))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerAdatper.ViewHolder =
        ViewHolder(ItemExhibitposterBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ViewPagerAdatper.ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
}