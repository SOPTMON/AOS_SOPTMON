package com.sopt.soptmon.daehwan

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sopt.soptmon.databinding.TvonLiveOnBlockElementBinding

class HomeBodyTvOnStaticBlockAdaptor(
    context: Context
) : RecyclerView.Adapter<HomeBodyTvOnStaticBlockAdaptor.ViewHolder>() {


    private var tvOnList = emptyList<TvOnElement>()

    private val inflater by lazy {
        LayoutInflater.from(context)
    }

    class ViewHolder(
        private val staticElementBinding: TvonLiveOnBlockElementBinding
    ) : RecyclerView.ViewHolder(staticElementBinding.root) {
        fun onBind(data: TvOnElement) {

            Glide.with(staticElementBinding.root)
                .load(data.imageUrl)
                .centerCrop()
                .into(staticElementBinding.imgTvonStatic)

            staticElementBinding.txTvonStatic.text = data.name

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            TvonLiveOnBlockElementBinding.inflate(inflater, parent, false)
        )
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        holder.onBind(tvOnList[position])
    }

    override fun getItemCount() = tvOnList.size

    fun setList(list: List<TvOnElement>) {
        tvOnList = list.toList()

        if (tvOnList.changed(list)) {
            notifyDataSetChanged()
        }
    }

    private fun <E> List<E>.changed(toBe: List<E>) =
        !(this.size == toBe.size && this.containsAll(toBe))
}